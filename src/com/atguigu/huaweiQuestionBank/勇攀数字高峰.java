package com.atguigu.huaweiQuestionBank;

import java.util.*;

/**
 * 题目描述
 * 你在给定的数字地形图中寻找登山路径，数字代表当前位置的海拔高度，要求从最低海拔出发，不断攀登，最终到达最高山峰，你需要寻找所有满足条件的登山路径。地图✅保证最低海拔和最高山峰只有一个。
 * 路径条件
 * 登山规则：路径海拔必须严格递增
 * 移动限制：可以上下左右 四个方向 移动
 * 路径限制：路径必须从最低海拔开始，到最高海拔结束访问限制：每个地点只能走一次
 * 高度差限制：每一个攀登高度必须大于0，小于等于指定值。
 * 输入描述
 * 输入一个二维数组 表示的海拔图，维度n*m(2<=n，m<=10)
 * 输入一个整数，参数表示单步最大允许的高度差
 * 输出描述
 * 输出满足条件的登山路径的数量
 */
public class 勇攀数字高峰 {


    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited = new boolean[15][15];
    static int sx, sy, ex, ey;

    // 递归回溯
    public static int dfs(int x, int y, int n, int m, int k, int[][] grid) {
        // 到达终点
        if (x == ex && y == ey) {
            return 1;
        }

        visited[x][y] = true;
        int res = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 越界
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

            // 重复
            if (visited[nx][ny]) continue;

            int diff = grid[nx][ny] - grid[x][y];

            if (diff > 0 && diff <= k) {
                res += dfs(nx, ny, n, m, k, grid);
            }
        }

        visited[x][y] = false; // 回溯
        return res;
    }

    public static int cal(int n, int m, int k, int[][] grid) {

        // 找到终点/起点坐标
        int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] < minVal) {
                    minVal = grid[i][j];
                    sx = i;
                    sy = j;
                }
                if (grid[i][j] > maxVal) {
                    maxVal = grid[i][j];
                    ex = i;
                    ey = j;
                }
            }
        }

        return dfs(sx, sy, n, m, k, grid);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(cal(n, m, k, grid));
    }

}
