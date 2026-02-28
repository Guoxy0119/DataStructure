package com.atguigu.leetcode100;

import java.util.TreeSet;

public class lc128 {

    public static void main(String[] args) {
//        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        int[] nums = new int[]{1,2,6,7,8};
        int i = longestConsecutive(nums);
        System.out.println(i);
    }


    public static int longestConsecutive(int[] nums) {
        if (nums.length < 1) {
            return nums.length;
        }
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int first = set.pollFirst();
        int count = 1;
        int res = 1;

        while (set.iterator().hasNext()) {
            Integer cur = set.pollFirst();
            if (first == cur - 1) {
                count++;
            } else {
                count = 1;
            }
            first = cur;
            res = Math.max(res, count);
        }

        return res;
    }


}
