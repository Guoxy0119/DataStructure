package com.atguigu.leetcode.string.easy;

import java.util.HashMap;

/**
 * 290. 单词规律
 * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 示例1:
 * 输入: pattern = "abba", s = "dog cat cat dog"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入:pattern = "abba", s = "dog cat cat fish"
 * 输出: false
 * <p>
 * 示例 3:
 * 输入: pattern = "aaaa", s = "dog cat cat dog"
 * 输出: false
 */
public class WordRule290 {

    public static void main(String[] args) {

//        String pattern = "abba", s = "dog cat cat dog";
        String pattern = "abba", s = "dog cat cat fish";


        boolean b = wordPattern(pattern, s);
        System.out.println(b);
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] pSplit = pattern.split("");
        String[] sSplit = s.split(" ");

        if (pSplit.length != sSplit.length) return false;

        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < pSplit.length; i++) {

            if (map.containsKey(pSplit[i])) {
                if (!map.get(pSplit[i]).equals(sSplit[i])) return false;
            } else if (map.containsValue(sSplit[i])) {
                return false;
            }

            map.put(pSplit[i], sSplit[i]);
        }


        return true;
    }

}
