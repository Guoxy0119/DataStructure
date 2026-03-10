package com.atguigu.leetcode100;

import java.util.Arrays;
import java.util.Comparator;

public class lc56 {

    public static void main(String[] args) {

//        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals = {{1, 4}, {2, 3}};
//        for (int[] interval : intervals) {
//            System.out.println(Arrays.toString(interval));
//        }


        int[][] merge = merge(intervals);
        System.out.println(Arrays.deepToString(merge));

    }


    public static int[][] merge(int[][] intervals) {

        int[][] result = new int[intervals.length][2];
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int index = 0;
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > right) {
                result[index][0] = left;
                result[index][1] = right;

                left = intervals[i][0];
                right = intervals[i][1];
                index++;
            } else {
                right = Math.max(intervals[i][1], right);
            }
        }
        result[index][0] = left;
        result[index][1] = right;

        return Arrays.copyOf(result, index + 1);//*****************  去除为0的占位
    }


}
