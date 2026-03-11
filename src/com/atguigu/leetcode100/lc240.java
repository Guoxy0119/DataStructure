package com.atguigu.leetcode100;

public class lc240 {

    public static void main(String[] args) {

        int[][] nums = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24},{18,21,23,26,30}};
        int target = 20;
//        int[][] nums = {{-1, 3}};
//        int target = 3;
        System.out.println(searchMatrix(nums, target));
    }

    /**
     * https://leetcode.cn/problems/search-a-2d-matrix-ii/solutions/2783938/tu-jie-pai-chu-fa-yi-tu-miao-dong-python-kytg/?envType=study-plan-v2&envId=top-100-liked
     * 从右上角向左下角推进
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        // 右上角的数据坐标y，x
        int y = 0, x = matrix[0].length - 1;

        while (y <= matrix.length - 1 && x >= 0) {
            if (matrix[y][x] == target) {
                return true;
            } else if (matrix[y][x] < target) {
                y++;
            } else if (matrix[y][x] > target) {
                x--;
            }
        }

        return false;
    }


    // 慢
    public static boolean searchMatrix1(int[][] matrix, int target) {

        int y = matrix.length, x = matrix[0].length;

        int indexx = -1;
        int indexy = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (target == matrix[i][j]) {
                    indexx = j;
                    indexy = i;
                    break;
                }
            }
        }

        if (indexx == -1 || indexy == -1) {
            return false;
        }

/*
        // 从上到下
        int temp = matrix[0][indexx];
        for (int i = 0; i < y; i++) {
            if (temp > matrix[i][indexx]) {
                return false;
            }
        }

        // 从左到右
        temp = matrix[indexy][0];
        for (int i = 0; i < x; i++) {
            if (temp > matrix[indexy][i]) {
                return false;
            }
        }
*/

        return true;
    }
}
