package com.atguigu.huawei;

/**
 * ？？？
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=188&&tqId=38622&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
 */
public class NC68JumpingStairs {

//    public int JumpFloor(int n) {
//        if (n == 1) return 1;
//        if (n == 2) return 2;
//        return JumpFloor(n - 1) + JumpFloor(n - 2);
//    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * https://blog.nowcoder.net/n/ef601ffbb33a42ff963f65364accd5cd?f=comment
     */
    public static int jumpFloor(int target) {
        if (target <= 1) {
            return 1;
        }
        // a 表示第 f[i-2] 项，b 表示第 f[i-1] 项
        int a = 1, b = 1, c = 0;
        for (int i = 2; i <= target; i++) {
            c = a + b; // f[i] = f[i - 1] + f[i - 2];
            // 为下一次循环求 f[i + 1] 做准备
            a = b; // f[i - 2] = f[i - 1]
            b = c; // f[i - 1] = f[i]
        }
        return c;
    }


    /**
     * https://blog.nowcoder.net/n/00145d2f12d244bb9e64aca49be21364?f=comment
     */
    public static int JumpFloor(int target) {
        if (target <= 2) {
            return target;
        }
        int pre2 = 1, pre1 = 2;
        for (int i = 3; i <= target; i++) {
            int cur = pre2 + pre1;
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }

    public static void main(String[] args) {

        /**
         * 2 = 1+1 ;2
         * 3 = 1+1+1; 1+2;2+1;
         * 4 = 1+1+1+1;1+1+2;1+2+1;2+1+1;2+2;
         */
        int i = JumpFloor(4);
        System.out.println(i);
    }


}
