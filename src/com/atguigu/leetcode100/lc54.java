package com.atguigu.leetcode100;

import java.util.ArrayList;
import java.util.List;

public class lc54 {

    public static void main(String[] args) {
        int[][] intervals = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

        List<Integer> integers = spiralOrder(intervals);
        //[1,2,3,4,8,12,11,10,9,5,6,7]
        System.out.println(integers);

    }


    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }


        /**
         * 1  2  3  4
         * 5  6  7  8
         * 9 10 11 12
         *
         *
         * 0,0  0,1  0,2  0,3
         * 1,0  1,1  1,2  1,3
         * 2,0  2,1  2,2  2,3
         *
         * 1    2   3   4
         * 10  11  12   5
         * 9    8   7   6
         * 5   +  2+2
         */

        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        List<Integer> result = new ArrayList<>(matrix.length * matrix[0].length);
        while (true) {

            // 从左到右
            for (int i = left; i <= right; i++) {
                result.add(matrix[up][i]);
            }
            up++;
            if (up > down) break;

            // 从上到下
            for (int i = up; i <= down; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            if (left > right) break;


            // 从右到左
            for (int i = right; i >= left; i--) {
                result.add(matrix[down][i]);
            }
            down--;
            if (up > down) break;


            // 从下到上
            for (int i = down; i >= up; i--) {
                result.add(matrix[i][left]);
            }
            left++;
            if (left > right) break;

        }


        return result;


    }
}
