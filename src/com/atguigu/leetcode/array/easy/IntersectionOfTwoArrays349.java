package com.atguigu.leetcode.array.easy;

import java.util.*;

/**
 * 349. 两个数组的交集
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集
 * 输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * <p>
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 */
public class IntersectionOfTwoArrays349 {

    public static void main(String[] args) {


        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] intersection = intersection(nums1, nums2);
        System.out.println(Arrays.toString(intersection));

    }






    /**
     * 我写的 速度极慢
     */
    public static int[] intersection(int[] nums1, int[] nums2) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    list.add(nums1[i]);
                }

            }
        }

        return list.stream().filter(Objects::nonNull).distinct().mapToInt(i -> i).toArray();
    }


    /**
     * hashset自动去重
     */
    public int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> commonNumSet = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            if (set1.contains(num)) {
                commonNumSet.add(num);
            }
        }
        return commonNumSet.stream().mapToInt(Integer::valueOf).toArray();
    }

}
