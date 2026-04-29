package com.atguigu.huaweiQuestionBank;

import java.util.*;

/**
 * 4K、2K、1080P、720P清晰度定义(清晰度:宽x高)如下:
 * • 4K:3840x 2160
 * • 2K: 2560 x 1440
 * 1080P:1920x 1080
 * • 720P: 1280x 720
 * 清晰度大小定义:720P<1080P<2K<4K
 * 分辨率(宽×高)匹配清晰度的规则:给定任意分辨率(宽×高)，宽和高同时都大于等于清晰度的宽、高定义时，才认为满足该清晰度定义，并且优先匹配高级别清晰度。
 * 例如:2600x1400:
 * • 2600<3840,1400<2160，不满足4K清晰度定义
 * ● 2600>2560,1400<1440，不满足2K清晰度定义
 * •2600>1920,1400>1080，满足1080P清晰度定义
 * 因此2600x1400是1080P清晰度。
 * 特别的:
 * 1.所有低于720P的清晰度，都认为是720P。
 * 2. 最大清晰度为4K，即只要满足4K清晰度标准的宽、高，无论多大，都归为4K。
 * 3.简化逻辑:不考虑交换宽高的情况，例如2500.3200，匹配为1080P，不能匹配为2K。
 * 分辨率大小规则:
 * 1. 优先比较该分辨率对应的清晰度大小
 * 2. 如果清晰度一致，则比较“面积(宽=宽x高)”
 * 3. 如果清晰度和面积一致，则比较“宽”
 * <p>
 * 输入描述
 * n组"宽x高"字符串☑，空格间隔，n<10
 * 输出描述
 * 从大到小排序的n组"宽x高"字符串，空格间隔
 */

class Node {
    int width;
    int height;
    int level;
    int area;

    Node(int width, int height, int level, int area) {
        this.width = width;
        this.height = height;
        this.level = level;
        this.area = area;
    }
}

public class 分辨率排序 {

    // 获取对应分辨率等级
    public static int getLevel(int width, int height) {
        if (width >= 3840 && height >= 2160) return 4;
        if (width >= 2560 && height >= 1440) return 3;
        if (width >= 1920 && height >= 1080) return 2;
        return 1;
    }

    public static String resolutionSort(String input) {
        String[] items = input.split(" ");
        List<Node> nodes = new ArrayList<>();

        for (String item : items) {
            String[] tmp = item.split("x");
            int width = Integer.parseInt(tmp[0]);
            int height = Integer.parseInt(tmp[1]);
            int level = getLevel(width, height);
            int area = width * height;

            nodes.add(new Node(width, height, level, area));
        }

        // 自定义排序
        nodes.sort((a, b) -> {
            if (a.level != b.level) return b.level - a.level;
            if (a.area != b.area) return b.area - a.area;
            return b.width - a.width;
        });

        // 构建结果字符串
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < nodes.size(); i++) {
            Node a = nodes.get(i);
            res.append(a.width).append("x").append(a.height);
            if (i != nodes.size() - 1) {
                res.append(" ");
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        System.out.println(resolutionSort(input));
    }

}
