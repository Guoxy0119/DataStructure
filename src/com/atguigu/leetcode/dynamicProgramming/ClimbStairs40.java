package com.atguigu.leetcode.dynamicProgramming;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * <p>
 * 示例 2：
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 */

/**
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定 n ，请计算 F(n) 。
 * <p>
 * 分析
 * 初始状态
 * f(0) = 0;
 * f(1) = 1;
 * <p>
 * 转移
 * F(n) = F(n - 1) + F(n - 2)
 * 结束状态
 * 求出f（n）并返回。
 */
public class ClimbStairs40 {

    public static void main(String[] args) {

        int n = 44;

        int i = climbStairs1(n);

    }


    /**
     * 标签：动态规划
     * 本问题其实常规解法可以分成多个子问题，爬第n阶楼梯的方法数量，等于 2 部分之和
     * <p>
     * 爬上 n−1 阶楼梯的方法数量。因为再爬1阶就能到第n阶
     * 爬上 n−2 阶楼梯的方法数量，因为再爬2阶就能到第n阶
     * 所以我们得到公式 dp[n]=dp[n−1]+dp[n−2]
     * 同时需要初始化 dp[0]=1 和 dp[1]=1
     * 时间复杂度：O(n)
     * <p>
     * 作者：画手大鹏
     * 链接：https://leetcode.cn/problems/climbing-stairs/solutions/9983/hua-jie-suan-fa-70-pa-lou-ti-by-guanpengchn/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    /**
     * 递归方法消耗大，更推荐使用动态规划的方法或加上一些记忆化技巧来提升性能。
     */
    public static int climbStairs1(int n) {
        if (n <= 0) return 0;
        int count = climbStairsRecursion1(n, 0);
        System.out.printf("总共有%d种方法", count);
        return count;
    }


    public static int climbStairsRecursion1(int n, int result) {
        if (n == 0) {
            result++;
            return result;
        }
        if (n >= 2) {
            result = climbStairsRecursion1(n - 2, result);
        }
        result = climbStairsRecursion1(n - 1, result);
        return result;
    }


}


