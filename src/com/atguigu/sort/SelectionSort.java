package com.atguigu.sort;

/**
 * 选择排序
 * 时间复杂度 big O(n^2)
 * 空间复杂度 big O(1)
 * 因为排序中始终只用到了数组大小的空间，为常数，因此空间复杂度为O(1)。
 */
public class SelectionSort {

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = 0; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }

    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

    }

}
