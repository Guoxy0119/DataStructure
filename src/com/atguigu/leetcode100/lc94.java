package com.atguigu.leetcode100;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 */
public class lc94 {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode();
        List<Integer> integers = inorderTraversal(treeNode);
        System.out.println(integers);
    }


    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(result, root);
        return result;
    }

    public static void dfs(List<Integer> result, TreeNode root) {
        if (root == null) return;
        dfs(result,root.left);
        result.add(root.val);
        dfs(result,root.right);
    }


}
