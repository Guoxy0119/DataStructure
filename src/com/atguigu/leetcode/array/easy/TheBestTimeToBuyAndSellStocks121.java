package com.atguigu.leetcode.array.easy;

/**
 * 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * 示例 1：
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天, （股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * *      注意利润不能是 7-1 = 6因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * <p>
 * 示例 2：
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class TheBestTimeToBuyAndSellStocks121 {

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};
//        int[] prices = {7, 6, 4, 3, 1};
//        int[] prices = {1};

        int i = maxProfit(prices);
        System.out.println(i);

    }


    /**
     * 在题目中，我们只要用一个变量记录一个历史最低价格 minprice，我们就可以假设自己的股票是在那天买的。
     * 那么我们在第 i 天卖出股票能得到的利润就是 prices[i] - minprice。
     */
    public static int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }

        int res = 0;
        int min = prices[0];

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > res) {
                res = prices[i] - min;
            }
        }

        return res;
    }


    /**
     * 超时！
     */
    public static int maxProfit2(int[] prices) {
        if (prices == null) {
            return 0;
        }

        int res = 0;
        int a = 0;
        int b = 1;

        while (a != prices.length - 1) {

            if (b == prices.length) {
                b = a + 1;
                a++;
            }

            if (prices[b] - prices[a] > res) {
                res = prices[b] - prices[a];
            }

            b++;
        }

        return res;
    }


    /**
     * 暴力解法，超时！
     */
    public static int maxProfit1(int[] prices) {
        if (prices == null) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i; j < prices.length; j++) {
                if (prices[j] - prices[i] > res) {
                    res = prices[j] - prices[i];
                }
            }
        }

        return res;

    }

}
