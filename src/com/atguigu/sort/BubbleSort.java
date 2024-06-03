package com.atguigu.sort;

/**
 * 冒泡排序
 * 时间复杂度 big O(n^2)
 * 空间复杂度 big O(1)
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }

        }

    }

    /**
     * 异或运算：相同为0，不同为1；可以理解为：无进位相加
     * 1. 0 ^ N = N
     * 2. N ^ N = 0
     * 3. 满足交换律和结合律 a ^ b ^ c = a ^ c ^ b
     * 4. 前提是 i位置 != j位置 若相等 则结果为0
     */
    public static void swap(int arr[], int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];

    }


}
