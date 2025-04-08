package com.atguigu.top;

import java.util.HashMap;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 * <p>
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/solutions/7399/hua-jie-suan-fa-3-wu-zhong-fu-zi-fu-de-zui-chang-z/
 */
public class TheLongestStringWithoutRepeatingCharacters3 {

    public static void main(String[] args) {
        String s = "dvdf";

        int i = lengthOfLongestSubstring(s);
        System.out.println(i);

    }


    public static int lengthOfLongestSubstring(String s) {

        int length = s.length();
        int start = 0;
        int end = 0;
        int res = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);

            Integer exist = map.get(c);
            if (exist != null) {
                /*
                 *********这里将开始的索引改到第一个重复字符的后一位*************
                 * 例：dvdf   即改到第一个d的后一位，v的位置，而不能直接将start改为i 即第二个d的位置，
                 */
                start = Math.max(map.get(c) + 1, start);
            }
            res = Math.max(res, end - start + 1);
            end++;

            map.put(c, i);
        }


        return res;
    }

}
