package com.atguigu.leetcode100;

import static com.atguigu.leetcode100.TreeNode.buildTree;

public class lc104 {

    public static void main(String[] args) {

        Integer[] input = {3, 9, 20, null, null, 15, 7};
        TreeNode treeNode = buildTree(input);

        int i = maxDepth(treeNode);
        System.out.println(i);

    }


    public static int maxDepth(TreeNode root) {

        int temp = 0;
        int result = 0;
        return dfs(result, temp, root);
    }

    public static int dfs(int result, int temp, TreeNode root) {
        if (root == null) {
            result = Math.max(result, temp);
            return result;
        }

        temp++;
        int left = dfs(result, temp, root.left);
        int right = dfs(result, temp, root.right);
        result = Math.max(result, left);
        result = Math.max(result, right);

        return result;
    }


}
