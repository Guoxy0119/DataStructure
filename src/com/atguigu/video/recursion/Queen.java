package com.atguigu.video.recursion;

/**
 * 8皇后问题
 */
public class Queen {

    //定义一个max表示共有多少个皇后
    int max = 8;
    //定义数组array，保存皇后放置位置的结果，比如arr = {0,4,7,5,2,6,1,3}
    int[] array = new int[max];
    static int count = 0;
    static int judgeCount = 0;


    public static void main(String[] args) {
        Queen queen = new Queen();
        queen.check(0);
        System.out.printf("一共有%d种解法", count);
        System.out.printf("一共判断冲突的次数%d次", judgeCount);

    }

    //编写一个方法，放置第n个皇后 n从0开始
    //特别注意：check是每一次递归时，进入到check中都有for(int i = 0; i < max; i++)，因此会有回溯
    public void check(int n) {
        if (n == max) {
            //n = 8 , 其实8个皇后就已经放好
            print();
            return;
        }

        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后n，放到该行的第1列
            array[n] = i;
            //判断当放置第n个皇后到i列时，是否冲突
            if (judge(n)) {
                //不冲突，接着放n+1个皇后
                check(n + 1);
            }
            //如果冲突，就继续执行array[n] = i; 即将第n个皇后，放置在本行的后移的一个位置
        }

    }


    /**
     * 查看当我们放置第n个皇后，就去检测该皇后是否和前面已经摆放的皇后冲突
     *
     * @param n 表示第n个皇后 n从0开始
     * @return true表示不冲突
     */
    private boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            //说明
            //1. array[i] == array[n] 表示判断第n个皇后是否和前面的n-1个皇后在同一列
            //2. Math.abs(n-i) == Math.abs(array[n] - array[i]) 表示判断第n个皇后是否和第i个皇后在同一斜线
            //3. 判断是否在同一行，没有必要，n每次都在递增
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    //写一个方法，可以将皇后摆放的位置输出
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

    }
}
