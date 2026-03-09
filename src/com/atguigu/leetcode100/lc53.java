package com.atguigu.leetcode100;

public class lc53 {

    public static void main(String[] args) {

//        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums = new int[]{-2};
        int i = maxSubArray(nums);
        System.out.println(i);

    }

    /**
     * https://leetcode.cn/problems/maximum-subarray/solutions/8975/hua-jie-suan-fa-53-zui-da-zi-xu-he-by-guanpengchn/?envType=study-plan-v2&envId=top-100-liked
     */
    public static int maxSubArray(int[] nums) {
        int result = nums[0];

        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            result = Math.max(result, sum);
        }
        return result;
    }


    // 超时
    public static int maxSubArray1(int[] nums) {
        int result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int right = i, temp = 0;
            while (right < nums.length) {
                temp += nums[right];
                result = Math.max(result, temp);
                right++;
            }
        }
        return result;
    }


}
