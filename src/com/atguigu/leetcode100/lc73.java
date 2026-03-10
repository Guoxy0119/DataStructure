package com.atguigu.leetcode100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class lc73 {

    public static void main(String[] args) {

//        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        System.out.println(Arrays.deepToString(matrix));
        setZeroes(matrix);

    }

    // 慢
    public static void setZeroes(int[][] matrix) {

        /**
         * 111
         * 101
         * 111
         *
         * 0120
         * 3452
         * 1315
         *
         */
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> xs = new HashSet<>();
        Set<Integer> ys = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] == 0) {
                    xs.add(j);
                    ys.add(i);
                }
            }
        }

//        for (Integer x : xs) {
//            for (int i = 0; i < m; i++) {
//                matrix[i][x] = 0;
//            }
//        }
//
//        for (Integer y : ys) {
//            for (int i = 0; i < n; i++) {
//                matrix[y][i] = 0;
//            }
//        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ys.contains(i) || xs.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }


        System.out.println(Arrays.deepToString(matrix));
    }


}
