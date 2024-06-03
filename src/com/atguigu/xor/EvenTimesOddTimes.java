package com.atguigu.xor;

/**
 * 1. 在一个数组中，有一种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这种数？
 * 2. 在一个数组中，有两种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这两种数？
 * 要求：时间复杂度O(N)，额外空间复杂度O(1)
 */
public class EvenTimesOddTimes {

    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }
        System.out.println(eor);

    }

    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }

        // eor = a ^ b
        // 两种数 所以 a != b
        // eor != 0 所以 eor必然有一个位置上是1
        int rightOne = eor & (~eor + 1); // 提取出eor最右的1：源码&补码   ~是取反
        int onlyOne = 0; // eor'
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) { // arr[i]这个数在这个位置上是1
                onlyOne ^= arr[i];
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));

    }
}
