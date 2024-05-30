package com.atguigu.leetcode.array.easy;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * <p>
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 */
public class SearchInsertLocation35 {

    public static void main(String[] args) {

//        int[] nums = {1, 3, 5, 6};
//        int target = 5;
        int[] nums = {1};
        int target = 0;
        int i = searchInsert(nums, target);
        System.out.println(i);

    }


    /**
     * 二分法
     */
    public static int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            //考虑到可能发生的整型溢出，使用 left + (right - left)/2 取mid更安全一点。
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return left;

    }

    public static int searchInsert1(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            } else if (target < nums[0]) {
                return 0;
            } else if (target > nums[nums.length - 1]) {
                return nums.length;
            } else if (nums[i] < target && target < nums[i + 1]) {
                return i + 1;
            }
        }

        return 0;
    }


}
