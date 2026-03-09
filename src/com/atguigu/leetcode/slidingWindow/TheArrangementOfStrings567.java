package com.atguigu.leetcode.slidingWindow;

import java.util.Arrays;

public class TheArrangementOfStrings567 {

    public static void main(String[] args) {

        String s1 = "ab", s2 = "a";
        boolean result = checkInclusion(s1, s2);
        System.out.println(result);

    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        // 获取字串字符，并初始化窗口
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(s1Count, s2Count)) {
            return true;
        }

        int index = 0;
        for (int i = s1.length(); i < s2.length(); i++) {
            s2Count[s2.charAt(i) - 'a']++;
            s2Count[s2.charAt(index++) - 'a']--;

            if (Arrays.equals(s1Count, s2Count)) {
                return true;
            }
        }

        return false;
    }


}
