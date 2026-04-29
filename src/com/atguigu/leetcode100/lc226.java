package com.atguigu.leetcode100;

import static com.atguigu.leetcode100.TreeNode.buildTree;

/**
 * 翻转二叉树
 */
public class lc226 {

    public static void main(String[] args) {

        Integer[] input = {1, 2};
        TreeNode treeNode = buildTree(input);

        TreeNode result = invertTree(treeNode);
        System.out.println(result);

    }


    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode result = new TreeNode();
        dfs(result, root);

        return result;
    }

    public static void dfs(TreeNode result, TreeNode root) {
        if (root == null) {
            return;
        }

        result.val = root.val;

        if (root.right != null) {
            result.left = new TreeNode();
            dfs(result.left, root.right);
        }else {
            result.left = null;
        }

        if (root.left != null) {
            result.right = new TreeNode();
            dfs(result.right, root.left);
        }else {
            result.right = null;
        }

    }
}
