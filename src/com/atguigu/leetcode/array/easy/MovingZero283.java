package com.atguigu.leetcode.array.easy;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 示例 2:
 * 输入: nums = [0]
 * 输出: [0]
 */
public class MovingZero283 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 3, 12};
//        int[] nums = {0};
//        int[] nums = {1,0,1};
        moveZeroes(nums);
    }


    /**
     * 简化一点
     */
    public static void moveZeroes(int[] nums) {

        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                //交换
                int temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
                left++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }


    public static void moveZeroes1(int[] nums) {

        int left = 0;
        int right = 1;

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[left] == 0 && nums[right] != 0) {
                //交换
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right++;
            } else if (nums[left] == 0 && nums[right] == 0) {
                right++;
            } else {
                left++;
                right++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

}
