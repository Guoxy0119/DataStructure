package com.atguigu.leetcode100;

import java.util.Arrays;
import java.util.HashMap;

public class lc1 {

    public static void main(String[] args) {

        int[] nums = new int[]{2, 7, 11, 15};

        System.out.println(Arrays.toString(twoSum(nums, 9)));

    }

    // 哈希
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];

            if (map.isEmpty() || map.get(target - num) == null) {
                map.put(nums[i], i);
            }else {
                res[0] = map.get(target - num);
                res[1] = i;
            }
        }
        return res;
    }

    // 暴力解法
    public static int[] twoSum1(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    break;
                }
            }
        }
        return res;
    }
}
