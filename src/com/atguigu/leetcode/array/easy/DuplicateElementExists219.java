package com.atguigu.leetcode.array.easy;

import java.util.HashMap;

/**
 * 219. 存在重复元素 II
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。
 * 如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 */
public class DuplicateElementExists219 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;


        boolean b = containsNearbyDuplicate(nums, k);
        System.out.println(b);
    }


    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null) {
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int index = 0;
        for (int num : nums) {

            Integer i = map.get(num);


        }

        System.out.println("测试分支合并");

        return true;
    }



}
