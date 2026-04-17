package com.atguigu.huaweiQuestionBank;

import java.util.*;

/**
 * 题目描述
 * 小王在玩一款叫做直捣黄龙的小游戏，在该游戏中他需要从入口位置进入敌营，绕过哨兵的层层封锁，达到敌军司令部实施斩首行动。
 * 敌军阵营是一个n*n的矩阵四，入口在坐标(0,n2)，敌军司令部在坐标(n-1,n2)，每个哨兵警戒以自己为中心的9宫格，一旦被哨兵发现则行动失败。同时穿越敌营耗时越长，被发现的概率越高，因此小王需要寻找到可以绕过警戒到达敌军司令部的最短路径。请你设计一个小程序，帮助小王统计这样的路径有多少条，以及路径长度。
 * 规则说明:
 * 1.其中n为大于1的奇数目取值小于30，坐标x,y取值均从0开始，敌营左下角定义为(0,0),右上角定义为(n-1,n-1)2.敌营入口在坐标(0,n/2)，敌军司令部在坐标(n-1，n/2)。
 * 3.游戏角色的行动方向只包含上、下、左、右四个方向，即一次行动x、y坐标不可同时变化。
 * 4.在没有满足题目要求的可达路径时，需要返回00。
 * 输入描述
 * 参数1，敌军阵营的边长n。
 * 参数2，哨兵位置列表Point{x，y}x未行坐标，y为列坐标。x和y以逗号分割，不同坐标以空格分割
 * 输出描述
 * 输出两个成员空格分割，第一个成员为最短路径条数，第二个成员为最短路径长度。
 */

class Point {
    int x, y;

    Point(int xx, int yy) {
        x = xx;
        y = yy;
    }
}

public class 直捣黄龙 {


    public static void main(String[] args) {
        /**
         * 5
         * 2,2
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // 吃掉换行
        String line = sc.nextLine();
        List<Point> points = new ArrayList<>();
        for (String s : line.split(" ")) {
            String[] rowCol = s.split(",");
            points.add(new Point(Integer.parseInt(rowCol[0]), Integer.parseInt(rowCol[1])));
        }

        int[] res = calShortestPath(n, points);
        System.out.println(res[0] + " " + res[1]);
    }

    static int[] calShortestPath(int n, List<Point> points) {
        int[][] grid = new int[n][n];
        // 标记不可达位置
        for (Point point : points) {
            int x = point.x;
            int y = point.y;
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    if (i < 0 || i >= n || j < 0 || j >= n) continue;
                    grid[i][j] = -1;
                }
            }
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int sx = 0, sy = n / 2;
        int ex = n - 1, ey = n / 2;

        // 特殊情况判断
        if (grid[sx][sy] == -1 || grid[ex][ey] == -1) return new int[]{0, 0};

        // dist 记录节点数，-1 表示未访问
        int[][] dist = new int[n][n];
        // distNum 最少节点数到达次数方案数
        int[][] distNum = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, -1);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx, sy});
        dist[sx][sy] = 1;
        distNum[sx][sy] = 1;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0], y = p[1];
            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];
                // 越界或被监控
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || grid[nx][ny] == -1) continue;

                // 初次访问
                if (dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    // 数量相同
                    distNum[nx][ny] = distNum[x][y];
                    q.offer(new int[]{nx, ny});
                } else if (dist[x][y] + 1 == dist[nx][ny]) {
                    distNum[nx][ny] += distNum[x][y];
                }
            }
        }

        // 不可达
        if (dist[ex][ey] == -1) return new int[]{0, 0};
        return new int[]{distNum[ex][ey], dist[ex][ey]};
    }

}
