package com.atguigu.leetcode100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class NGlc438 {

    public static void main(String[] args) {

        String s = "cbaebabacd", p = "abc";

        List<Integer> anagrams = findAnagrams(s, p);
        System.out.println(anagrams);

    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen) return result;

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // 统计 p 中每个字符的出现次数 并 初始化第一个窗口
        for (int i = 0; i < pLen; i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        // 检查第一个窗口
        if (Arrays.equals(pCount, sCount)) {
            result.add(0);
        }

        // 滑动窗口
        for (int i = pLen; i < sLen; i++) {
            // 加入新字符
            sCount[s.charAt(i) - 'a']++;
            // 移除旧字符（窗口左边界）
            sCount[s.charAt(i - pLen) - 'a']--;

            // 比较计数是否相等
            if (Arrays.equals(pCount, sCount)) {
                result.add(i - pLen + 1);
            }
        }
        return result;
    }


    // 超时
    public static List<Integer> findAnagrams1(String s, String p) {
        List<Integer> result = new ArrayList<>();

        HashMap<Character, Integer> pMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        int start = 0;
        for (int end = p.length() - 1; end < s.length(); end++) {

            String sub = s.substring(start, end + 1);

            HashMap<Character, Integer> tempMap = new HashMap<>(pMap);

            for (int i = 0; i < sub.length(); i++) {
                if (!tempMap.containsKey(sub.charAt(i))) {
                    break;
                } else if (tempMap.containsKey(sub.charAt(i))) {
                    Integer i1 = tempMap.get(sub.charAt(i));
                    if (i1 < 1) {
                        break;
                    }
                    tempMap.put(sub.charAt(i), i1 - 1);
                    if (i == sub.length() - 1) {
                        result.add(start);
                    }
                }
            }
            start++;
        }

        return result;
    }


}
