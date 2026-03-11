package com.atguigu.leetcode100;

import java.util.Arrays;

public class lc48 {

    public static void main(String[] args) {

        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));

    }


    public static void rotate(int[][] matrix) {

        int n = matrix.length;
        int index = n;// 用于里层循环，里层的数据要比外层数据少循环2次，由于里层已经从i开始，所以这里只需要-1

        int down = n - 1;
        int right = n - 1;

        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < index - 1; j++) {
                int temp = matrix[i][j];
                // 左上 ，x减小，而y=0不变
                matrix[i][j] = matrix[down - j][i];
                // 左下 ， x = down不变，y减小
                matrix[down - j][i] = matrix[down - i][right - j];
                // 右下， x增加，y = right不变
                matrix[down - i][right - j] = matrix[j][right - i];
                // 右上， x= 0不变，y增加
                matrix[j][right - i] = temp;
            }
            index--;

        }
    }
    /**
     *
     * 数据坐标
     * 0,0  0,1  0,2  0,3
     * 1,0  1,1  1,2  1,3
     * 2,0  2,1  2,2  2,3
     * 3,0  3,1  3,2  3,3
     *
     * 3,0  2,0  1,0  0,0
     * 3,1  2,1  1,1  0,1
     * 3,2  2,2  1,2  0,2
     * 3,3  2,3  1,3  0,3
     *
     *
     *
     */
}
