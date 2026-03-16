package com.atguigu.leetcode100;

import java.util.Arrays;

public class lc31 {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

    }


    public static void nextPermutation(int[] nums) {

        int n = nums.length;

        // 第一步：从右向左找到第一个小于右侧相邻数字的数 nums[i]
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // 如果找到了，进入第二步；否则跳过第二步，翻转整个数组
        if (i > 0) {
            // 第二步：从右向左找到第一个大于 nums[i] 的数 nums[j]
            int j = n - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            // 交换 nums[i] 和 nums[j]
            swap(nums, i, j);

        }

        // 第三步：反转[i+1,n-1] (如果上面跳过第二步，此时i=-1)
        reverse(nums, i + 1, n - 1);

    }


    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }

}
