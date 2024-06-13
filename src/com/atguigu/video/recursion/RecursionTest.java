package com.atguigu.video.recursion;

public class RecursionTest {

    public static void main(String[] args) {
        //通过打印问题，回顾递归调用机制
//        test(4);

        int res = factorial(3);
        System.out.println(res);

    }

    /**
     * 阶乘问题
     * 4! = 4*3*2*1
     */
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }


    /**
     * 打印问题
     */
    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println("n = " + n);
    }

}
