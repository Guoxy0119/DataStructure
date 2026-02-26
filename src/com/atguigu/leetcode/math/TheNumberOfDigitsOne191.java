package com.atguigu.leetcode.math;

/**
 * 191-位1的个数
 * 给定一个正整数 n，编写一个函数，获取一个正整数的二进制形式并返回其二进制表达式中
 * 设置位的个数（也被称为汉明重量）。
 * <p>
 * 示例 1：
 * 输入：n = 11
 * 输出：3
 * 解释：输入的二进制串 1011 中，共有 3 个设置位。
 * <p>
 * 示例 2：
 * 输入：n = 128
 * 输出：1
 * 解释：输入的二进制串 10000000 中，共有 1 个设置位。
 * <p>
 * 示例 3：
 * 输入：n = 2147483645
 * 输出：30
 * 解释：输入的二进制串 1111111111111111111111111111101 中，共有 30 个设置位。
 */
public class TheNumberOfDigitsOne191 {

    public static void main(String[] args) {

        int n = 11;
        hammingWeight(n);
    }

    public static int hammingWeight(int n) {

        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
        }



        return 0;

    }


}
