package com.atguigu.leetcode100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 注意去重！！！
 */
public class lc15 {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{2, -3, 0, -2, -5, -5, -4, 1, 2, -2, 2, 0, 2, -4, 5, 5, -10}));
//        System.out.println(threeSum(new int[]{0, 0, 0, 0}));
//        System.out.println(threeSum(new int[]{-100, -70, -60, 110, 120, 130, 160}));
//        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }


    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0) {
                break;
            }
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++; // 去重
                    while (left < right && nums[right] == nums[right - 1]) right--; // 去重
                }
                if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
