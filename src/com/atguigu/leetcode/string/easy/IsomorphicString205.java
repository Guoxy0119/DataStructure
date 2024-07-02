package com.atguigu.leetcode.string.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * <p>
 * 示例 1:
 * 输入：s = "egg", t = "add"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：s = "paper", t = "title"
 * 输出：true
 */
public class IsomorphicString205 {

    public static void main(String[] args) {

        String s = "egg", t = "add";
//        String s = "badc", t = "baba";

        boolean isomorphic = isIsomorphic(s, t);
        System.out.println(isomorphic);
    }


    /**
     * 大佬写法
     */
    public boolean isIsomorphic1(String s, String t) {
        int n = s.length();
        if (n == 0) return true;
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if (map.containsKey(ch1)) {
                if (map.get(ch1) != ch2) return false;
            } else if (map.containsValue(ch2)) return false;
            map.put(ch1, ch2);
        }
        return true;
    }


    /**
     * 我的写法
     */
    public static boolean isIsomorphic(String s, String t) {
        if (s.isEmpty() && t.isEmpty()) return true;
        if (s.length() != t.length()) return false;


        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sStr = s.charAt(i);
            char tStr = t.charAt(i);

            String s1 = map.get(String.valueOf(sStr));
            if ((s1 == null || s1.isEmpty()) && !map.containsValue(String.valueOf(tStr))) {
                map.put(String.valueOf(sStr), String.valueOf(tStr));
            } else if (s1 == null || !s1.equals(String.valueOf(tStr))) {
                return false;
            }
        }
        return true;

    }
}
