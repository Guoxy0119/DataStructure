package com.atguigu.leetcode.array.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,1]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：nums = [1,1,1,3,3,4,3,2,4,2]
 * 输出：true
 */
public class PresenceOfDuplicateElements217 {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1};
        boolean b = containsDuplicate1(nums);
        System.out.println(b);
    }

    public static boolean containsDuplicate1(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int x : nums) {
            if (!set.add(x)) {
                return true;
            }
        }
        return false;
    }


    public static boolean containsDuplicate(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer i = map.get(num);
            if (i == null) {
                map.put(num, 1);
            } else {
                return true;
            }
        }
        return false;
    }

}
