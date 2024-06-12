package com.atguigu.leetcode.math;

/**
 * 将购买后的账户余额取整
 * 一开始，你的银行账户里有 100 块钱。
 * 给你一个整数purchaseAmount ，它表示你在一次购买中愿意支出的金额。
 * 在一个商店里，你进行一次购买，实际支出的金额会向 最近 的 10 的 倍数 取整。换句话说，你实际会支付一个 非负 金额 roundedAmount ，
 * 满足 roundedAmount 是 10 的倍数且 abs(roundedAmount - purchaseAmount) 的值 最小 。
 * 如果存在多于一个最接近的 10 的倍数，较大的倍数 是你的实际支出金额。
 * 请你返回一个整数，表示你在愿意支出金额为 purchaseAmount 块钱的前提下，购买之后剩下的余额。
 * 注意： 0 也是 10 的倍数。
 * <p>
 * 示例 1：
 * 输入：purchaseAmount = 9
 * 输出：90
 * 解释：这个例子中，最接近 9 的 10 的倍数是 10 。所以你的账户余额为 100 - 10 = 90 。
 * <p>
 * 示例 2：
 * 输入：purchaseAmount = 15
 * 输出：80
 * 解释：这个例子中，有 2 个最接近 15 的 10 的倍数：10 和 20，较大的数 20 是你的实际开销。
 * 所以你的账户余额为 100 - 20 = 80 。
 */
public class RoundUpTheAccountBalanceAfterPurchase2806 {

    public static void main(String[] args) {

        int purchaseAmount = 15;
        int i = accountBalanceAfterPurchase(purchaseAmount);
        System.out.println(i);

    }

    /**
     * 大神解法
     * 题目意思是把 purchaseAmount\textit{purchaseAmount}purchaseAmount 的个位数「四舍五入」，例如 121212 四舍五入到 101010，151515 四舍五入到 202020。
     * 也就是：
     * 当个位数 ≤4时，把个位数变成 0。
     * 当个位数 ≥5时，把个位数变成 0，然后增加 10。
     * 这两种情况可以统一为如下公式
     */
    public static int accountBalanceAfterPurchase(int purchaseAmount) {
        return 100 - (purchaseAmount + 5) / 10 * 10;
    }

    public static int accountBalanceAfterPurchase1(int purchaseAmount) {
        return 100 - Math.round((float) purchaseAmount / 10) * 10;
    }


}
