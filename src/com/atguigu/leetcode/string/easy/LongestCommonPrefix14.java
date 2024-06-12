package com.atguigu.leetcode.string.easy;

/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * <p>
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 */
public class LongestCommonPrefix14 {

    public static void main(String[] args) {

//        String[] strs = {"flower","flower","flower","flower"};
//        String[] strs = {"reflower", "flow", "flight"};
//        String[] strs = {"ab", "a"};
//        String[] strs = {"a"};
//        String[] strs = {"flower", "flow", "flight"};
//        String[] strs = {"aaa", "aa", "aaa"};
        String[] strs = {"ca", "a"};
//        String[] strs = {"dog", "racecar", "car"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);

    }

    /**
     * 大神写法
     * 当字符串数组长度为 0 时则公共前缀为空，直接返回；
     * 令最长公共前缀 ans 的值为第一个字符串，进行初始化；
     * 遍历后面的字符串，依次将其与 ans 进行比较，两两找出公共前缀，最终结果即为最长公共前缀；
     * 如果查找过程中出现了 ans 为空的情况，则公共前缀不存在直接返回；
     * 时间复杂度：O(s)，s 为所有字符串的长度之和。
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) break;
            }
            ans = ans.substring(0, j);
            if (ans.equals("")) return ans;
        }
        return ans;
    }


    public static String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String temp = strs[0];

        for (String str : strs) {
            if (str.length() < temp.length()) {
                temp = str;

            }
        }

        String res = temp;
        for (int i = temp.length(); i > 0; i--) {
            for (String str : strs) {
                if (!str.substring(0, i).equals(temp.substring(0, i))) {

                    res = temp.substring(0, i - 1);

                }
            }
        }


        return res;
    }
}
