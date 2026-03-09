package com.atguigu.leetcode100;

import java.util.HashMap;

public class lc3 {


    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring(" "));
//        System.out.println(lengthOfLongestSubstring("bbbbb"));
//        System.out.println(lengthOfLongestSubstring("dvdf"));
//        System.out.println(lengthOfLongestSubstring("pwwkew"));

    }

    // 滑动窗口
    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            char cur = s.charAt(right);
            if (map.containsKey(cur)) {
                left = Math.max(left, map.get(cur));//*********
            }
            map.put(cur, right + 1);
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }


//    public static int lengthOfLongestSubstring(String s) {
//        int result = 0;
//        HashMap<Character, Integer> map = new HashMap<>();
//        for (int i = s.length() - 1; i >= 0; i--) {
//
//            int l = 0;
//            int r = i;
//            while (l <= r) {
//                if (map.containsKey(s.charAt(r))) {
//                    break;
//                } else {
//                    map.put(s.charAt(r), r);
//                    r--;
//                }
//            }
//
//            result = Math.max(result, map.size());
//            map.clear();
//        }
//        return result;
//    }

}
