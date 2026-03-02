package com.atguigu.leetcode100;

public class lc121 {

    public static void main(String[] args) {

        System.out.println(maxProfit(new int[]{7,6,4,3,1}));

    }


    public static int maxProfit(int[] prices) {

        int result = 0;

        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min,prices[i]);
            result = Math.max(result, prices[i] - min);
        }

        return result;

    }


}
