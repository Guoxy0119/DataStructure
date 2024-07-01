package com.atguigu.leetcode.string.easy;

/**
 * 392. 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 进阶：
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * <p>
 * 示例 1：
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 */
public class JudgmentSubsequence392 {

    public static void main(String[] args) {

        String s = "abc";
        String t = "ahbgdc";

//        String s = "";
//        String t = "ahbgdc";

        boolean subsequence = isSubsequence(s, t);
        System.out.println(subsequence);

    }


    /**
     * 大佬写法双指针
     */
    public static boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

    /**
     * 大佬写法
     */
    public static boolean isSubsequence2(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        int i = 0;
        for (char c : t.toCharArray()) {
            if (s.charAt(i) == c && ++i == s.length()) { // 所有字符匹配完毕
                return true; // s 是 t 的子序列
            }
        }
        return false;
    }


    /**
     * 我的方法
     */
    public static boolean isSubsequence1(String s, String t) {

        if (s.isEmpty()) {
            return true;
        }

        String[] sStr = s.split("");
        String[] tStr = t.split("");

        int p1 = 0;
        int p2 = 0;


        while (p1 < sStr.length && p2 < tStr.length) {

            if (sStr[p1].equals(tStr[p2])) {
                p1++;
            }
            p2++;

        }
        // 如果p1大于sStr.length，说明sStr已经遍历完且最后一个字母也已经匹配到了，返回true
//        return p1 > sStr.length - 1;
        return p1 == sStr.length;

    }
}
