package com.atguigu.leetcode.array.easy;

import java.util.Arrays;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * <p>
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 */
public class ValidHeterotopicAlphabets242 {
    public static void main(String[] args) {

        String s = "anagram";
        String t = "nagaram";

        boolean anagram = isAnagram(s, t);
        System.out.println(anagram);
    }


    public static boolean isAnagram(String s, String t) {
        char[] sarray = s.toCharArray();
        Arrays.sort(sarray);

        char[] tarray = t.toCharArray();
        Arrays.sort(tarray);

        return Arrays.equals(sarray, tarray);

    }
}
