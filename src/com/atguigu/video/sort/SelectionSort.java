package com.atguigu.video.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 时间复杂度 big O(n^2)
 * 空间复杂度 big O(1)
 * 因为排序中始终只用到了数组大小的空间，为常数，因此空间复杂度为O(1)。
 * 选择排序比冒泡排序用的时间少，因为只在arr[j] < arr[minIndex]时，且minIndex != i 最小值不是自己时，才进行交换
 */
public class SelectionSort {

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
            System.out.println("第" + (i + 1) + "趟排序后的数组");
            System.out.println(Arrays.toString(arr));
        }

    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        selectionSort(arr);

    }

}
