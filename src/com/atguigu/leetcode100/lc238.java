package com.atguigu.leetcode100;

import java.util.Arrays;

public class lc238 {


    public static void main(String[] args) {

        int[] nums = {-1, 1, 0, -3, 3};

        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }


    public static int[] productExceptSelf(int[] nums) {

        /**
         * 1  234
         * 1 2 34
         * 12 3 4
         * 123  4
         *
         *
         */

        int length = nums.length;
        int[] result = new int[length];

        // 前
        int temp = 1;
        int[] pre = new int[length];
        pre[0] = 1;
        for (int i = 1; i < length; i++) {
            pre[i] = temp * nums[i - 1];
            temp = pre[i];
        }


        // 后
        temp = 1;
        int[] suf = new int[length];
        suf[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            suf[i] = temp * nums[i + 1];
            temp = suf[i];
        }


        for (int i = 0; i < length; i++) {
            result[i] = pre[i] * suf[i];
        }
        return result;
    }


}
