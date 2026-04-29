package com.atguigu.huaweiQuestionBank;

import java.util.*;


/**
 * 题目描述
 * WIFI网络中，专业的网络规划不仅可以提升业务体验，还可以减少部署Q成本。把办公区可以看作一个n*m 的网格，部分网格包含墙壁(无法放置AP(WI一FI设备)，部分为空地(可以放置AP)。每个AP覆盖范围是一个3*3 的正方形(包括自身位置、上下左右、以及对角线区域)，且AP和AP的覆盖区域不能重叠，防止相互干扰。
 * 现在给定一个mX n(不超过50*50)的网络布局图(墙壁用字符#表示，空地用字符.表示)，请设计一个算法，计算最少放置多少数量的AP来覆盖所有空地?如果不能按条件完成覆盖，请返回-1。
 * 输入描述
 * 第一行输入m n
 * 接下来m行输入每一行字符
 * 输出描述
 * 最少放置多少数量的AP来覆盖所有空地?如果不能按条件完成覆盖，请返回-1。
 */
public class wifi设备网络规划 {


    static int n, m;
    static char[][] g;

    static int[][] id = new int[55][55];
    static int tot;

    // AP结构：覆盖点 + 3x3占用格子
    static class AP {
        ArrayList<Integer> dots = new ArrayList<>(); // 覆盖的'.'
        ArrayList<int[]> cells = new ArrayList<>();   // 3x3占用格子
    }

    static ArrayList<AP> apList = new ArrayList<>();
    static ArrayList<Integer>[] pointToAP;

    // 空地是否被覆盖
    static boolean[] covered = new boolean[2500];

    // 格子是否被占用（用于冲突）
    static boolean[][] used = new boolean[55][55];

    static int ans;

    static int[] dx = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

    // 判断是否在网格内
    static boolean in(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    // 预处理候选AP信息
    static void buildAP() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] != '.') continue;

                AP ap = new AP();

                for (int k = 0; k < 9; k++) {
                    int x = i + dx[k], y = j + dy[k];
                    if (!in(x, y)) continue;

                    ap.cells.add(new int[]{x, y});

                    // 覆盖空地
                    if (g[x][y] == '.') {
                        ap.dots.add(id[x][y]);
                    }
                }

                apList.add(ap);
            }
        }
    }

    // 计算剩余未覆盖点
    static int remain() {
        int c = 0;
        for (int i = 0; i < tot; i++)
            if (!covered[i]) c++;
        return c;
    }

    // 选取最佳点（MRV：候选最少）
    static int selectPoint() {
        int best = -1, bestCnt = 3000;

        for (int i = 0; i < tot; i++) {
            if (covered[i]) continue;

            int cnt = 0;

            for (int ap : pointToAP[i]) {
                boolean ok = true;

                // 判断3x3是否冲突
                for (int[] c : apList.get(ap).cells) {
                    if (used[c[0]][c[1]]) {
                        ok = false;
                        break;
                    }
                }

                if (ok) cnt++;
            }

            // 无法覆盖直接失败
            if (cnt == 0) return -1;

            if (cnt < bestCnt) {
                bestCnt = cnt;
                best = i;
            }
        }

        return best;
    }

    // DFS回溯
    static void dfs(int usedCnt) {

        if (usedCnt >= ans) return;

        // 判断是否全部覆盖
        boolean all = true;
        for (int i = 0; i < tot; i++) {
            if (!covered[i]) {
                all = false;
                break;
            }
        }

        if (all) {
            ans = usedCnt;
            return;
        }

        // 下界剪枝：最多每个AP覆盖9个点
        int lb = (remain() + 8) / 9;
        if (usedCnt + lb >= ans) return;

        // MRV选点
        int p = selectPoint();
        if (p == -1) return;

        ArrayList<Integer> cand = new ArrayList<>();

        // 枚举候选AP
        for (int ap : pointToAP[p]) {
            boolean ok = true;

            for (int[] c : apList.get(ap).cells) {
                if (used[c[0]][c[1]]) {
                    ok = false;
                    break;
                }
            }

            if (ok) cand.add(ap);
        }

        // 优先选择覆盖多的AP
        cand.sort((a, b) -> apList.get(b).dots.size() - apList.get(a).dots.size());

        for (int ap : cand) {

            ArrayList<int[]> oldCells = new ArrayList<>();
            ArrayList<Integer> oldDots = new ArrayList<>();

            // 放置AP（标记占用）
            for (int[] c : apList.get(ap).cells) {
                if (!used[c[0]][c[1]]) {
                    used[c[0]][c[1]] = true;
                    oldCells.add(c);
                }
            }

            // 标记覆盖
            for (int d : apList.get(ap).dots) {
                if (!covered[d]) {
                    covered[d] = true;
                    oldDots.add(d);
                }
            }

            dfs(usedCnt + 1);

            // 回溯恢复
            for (int[] c : oldCells) {
                used[c[0]][c[1]] = false;
            }
            for (int d : oldDots) {
                covered[d] = false;
            }
        }
    }

    static int solve() {
        pointToAP = new ArrayList[2500];
        for (int i = 0; i < 2500; i++) pointToAP[i] = new ArrayList<>();

        tot = 0;

        // 空地编号
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == '.') {
                    id[i][j] = tot++;
                }
            }
        }

        if (tot == 0) return 0;

        buildAP();

        // 反向索引：点 -> AP
        for (int i = 0; i < apList.size(); i++) {
            for (int d : apList.get(i).dots) {
                pointToAP[d].add(i);
            }
        }

        ans = Integer.MAX_VALUE;
        dfs(0);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        g = new char[55][55];

        for (int i = 0; i < n; i++) {
            g[i] = sc.nextLine().toCharArray();
        }

        System.out.println(solve());
    }

}
