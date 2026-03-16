package com.atguigu.leetcode100;

import java.util.Arrays;

public class lc75 {

    public static void main(String[] args) {

        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);

        System.out.println(Arrays.toString(nums));
    }


    //整数 0、 1 和 2 分别表示红色、白色和蓝色。

    /**
     * [2, 0, 2, 1, 1, 0] p0 = 0;p1 = 0
     * [0, 2, 2, 1, 1, 0] p0 = 1;p1 = 1
     * [0, 2, 2, 1, 1, 0] p0 = 1;p1 = 1
     * [0, 1, 2, 2, 1, 0] p0 = 1;p1 = 2
     * [0, 1, 1, 2, 2, 0] p0 = 1;p1 = 3
     * [0, 0, 1, 1, 2, 2] p0 = 2;p1 = 4
     */
    public static void sortColors(int[] nums) {

        int p0 = 0;
        int p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            nums[i] = 2;
            if (num < 2) {
                nums[p1++] = 1;
            }
            if (num < 1) {
                nums[p0++] = 0;
            }

            System.out.println(Arrays.toString(nums));
            System.out.println("p0 = " + p0 + ";p1 = " + p1);
        }


    }
}
