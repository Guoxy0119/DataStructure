package com.atguigu.huaweiQuestionBank;

import java.util.*;

/**
 * 题目描述
 * 员工A的磁盘空间经常被耗尽，他需要找到占用空间最大的目录或文件，然后决定如何清理文件释放空间。
 * 给定某一目录，请白那些程序帮他统计目录内一级子目录和文件的占用空间，并返回目标目录一级子项(文件或子目录)中占用空间最大的项。
 * 规则说明:
 * 1. 目录占用空间为其内部所有文件 size的总和，目录本身size为0
 * 2.目录深度不高于7，目录或文件名总长度不超过128字节
 * 3.当存在多个子项占用空间均为最大时，多个子项采用字符升序排列。
 * 4.目标目录不再文件系统中时(输入路径前缀匹配不到任何路径)，返回空列表。
 * 输入描述
 * 输入要统计的目标目录文件系统☑内的文件列表
 * 文件Size 列表，该列表中的数据和文件列表存在一一对应关系。
 * 输出描述
 * 目标目录一级子项(文件或子目录)中占用空间最大的项组成的列表。
 *
 *
 */
public class 空间占用计算 {


    // 目录节点
    static class Node {
        Map<String, Node> childrenDir = new HashMap<>();
        Map<String, Node> childrenFile = new HashMap<>();
        String name;
        int size = 0;
    }

    // DFS 计算目录大小
    static int dfs(Node root) {
        int sum = 0;

        // 子目录
        for (Node node : root.childrenDir.values()) {
            sum += dfs(node);
        }

        // 文件
        for (Node node : root.childrenFile.values()) {
            sum += node.size;
        }

        root.size = sum;
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String path = sc.nextLine();
        String file = sc.nextLine();
        String fileSize = sc.nextLine();

        String[] fileList = file.split(" ");
        String[] sizeArr = fileSize.split(" ");

        Node root = new Node();

        // 构建目录树
        for (int i = 0; i < fileList.length; i++) {
            String[] parts = fileList[i].split("/");
            Node cur = root;

            for (int j = 1; j < parts.length; j++) {
                String name = parts[j];
                boolean isFile = (j == parts.length - 1);

                if (!isFile) {
                    cur.childrenDir.putIfAbsent(name, new Node());
                    cur.childrenDir.get(name).name = name;
                    cur = cur.childrenDir.get(name);
                } else {
                    Node fileNode = new Node();
                    fileNode.name = name;
                    fileNode.size = Integer.parseInt(sizeArr[i]);
                    cur.childrenFile.put(name, fileNode);
                }
            }
        }

        // 找目标目录
        Node cur = root;
        String[] parts = path.split("/");

        for (int i = 1; i < parts.length; i++) {
            if (!cur.childrenDir.containsKey(parts[i])) {
                return;
            }
            cur = cur.childrenDir.get(parts[i]);
        }

        dfs(cur);

        List<Node> list = new ArrayList<>();
        list.addAll(cur.childrenDir.values());
        list.addAll(cur.childrenFile.values());

        if (list.isEmpty()) return;

        // 排序
        list.sort((a, b) -> {
            if (a.size == b.size) return a.name.compareTo(b.name);
            return b.size - a.size;
        });

        int max = list.get(0).size;

        for (Node node : list) {
            if (node.size != max) break;
            System.out.print(node.name + " ");
        }
    }

}
