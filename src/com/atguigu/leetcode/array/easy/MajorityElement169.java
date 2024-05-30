package com.atguigu.leetcode.array.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例 1：
 * 输入：nums = [3,2,3]
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 */
public class MajorityElement169 {
    public static void main(String[] args) {

        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int i = majorityElement2(nums);
        System.out.println(i);

    }


    /**
     * 排序
     * 如果将数组 nums 中的所有元素按照单调递增或单调递减的顺序排序，那么下标为 n/2的元素（下标从 0 开始）一定是众数。
     */
    public static int majorityElement2(int[] nums) {

        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


    /**
     * 哈希表
     */
    public static int majorityElement1(int[] nums) {

        int length = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > length / 2) {
                return entry.getKey();
            }
        }

        return 0;

    }

}
