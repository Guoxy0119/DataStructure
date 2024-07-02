package com.atguigu.leetcode.string.easy;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 383. 赎金信
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * <p>
 * 示例 1：
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * <p>
 * 示例 2：
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 */
public class RansomLetter383 {

    public static void main(String[] args) {

        String ransomNote = "aa", magazine = "aab";

        boolean b = canConstruct(ransomNote, magazine);
        System.out.println(b);

    }


    public boolean canConstruct1(String ransomNote, String magazine) {
        for (int i = 0; i < ransomNote.length(); i++) {
            String c = String.valueOf(ransomNote.charAt(i));
            if (magazine.contains(c)) {
                magazine = magazine.replaceFirst(c, "");
            } else {
                return false;
            }
        }
        return true;
    }


    /**
     * 我写的
     */
    public static boolean canConstruct(String ransomNote, String magazine) {

        Map<String, Long> ransomNoteMap = Arrays.stream(ransomNote.split("")).collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        Map<String, Long> magazineMap = Arrays.stream(magazine.split("")).collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        for (Map.Entry<String, Long> entry : ransomNoteMap.entrySet()) {

            String key = entry.getKey();
            Long value = entry.getValue();

            Long l = magazineMap.get(key);
            if (l == null || l == 0 || l < value) {
                return false;
            }

        }


        return true;

    }

}
