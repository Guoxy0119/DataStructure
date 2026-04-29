package com.atguigu.huaweiQuestionBank;

import java.util.*;


/**
 * 题目描述
 * 1.输入M，ɴ两个数，则按照以下规则形成一个数列。
 * 2.数列的前M个元素的值为1到M
 * 3.从M+1个元素开始，计算逻辑为
 * 1.如果其前Μ个元素中，存在值相同的元素，则该位置上的数值等于前m个数中最大数值与最小数值之和。
 * 2.如果其前Μ个元素中，不存在值相同的元素，则该位置上的数值等于前M个数中最大的数值和最小数值之差。
 * 请计算该数列第ɴ个位置上的数值补充
 * 3 <=M<= 10
 * 1<=N<= 50
 * 输入描述
 * 输出N和M，使用，分割
 * 输出描述
 * 输出N位置上的数值
 */
public class 计算数列位置N的值 {

    /**
     * m= 4; n=8;
     * 1,2,3,4,  3,5,6,3,  9,6
     */


    public static int positionValue(int m, int n) {
        if (n <= m) {
            return n;
        }

        int result = 0;
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= m; i++) {
            queue.add(i);
        }

        for (int i = 0; i < n - m; i++) {
/*            int max = Collections.max(queue);
            int min = Collections.min(queue);
            HashSet<Integer> set = new HashSet<>();
            boolean exist = false;
            for (Integer integer : queue) {
                if (set.contains(integer)) {
                    exist = true;
                }
                set.add(integer);
                max = Math.max(max, integer);
                min = Math.min(min, integer);
            }

            if (exist) {
                queue.add(max + min);
            } else {
                queue.add(max - min);
            }
            queue.poll();*/


            // 简化代码
            int max = Collections.max(queue);
            int min = Collections.min(queue);
            HashSet<Integer> set = new HashSet<>(queue);
            boolean exist = set.size() < m;
            int next = exist ? max + min : max - min;
            queue.add(next);
            queue.poll();
        }
        result = queue.getLast();
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] parts = input.split(",");

//        int m = Integer.parseInt(parts[0]);
//        int n = Integer.parseInt(parts[1]);

        int m = 4;
        int n = 7;

        System.out.println(positionValue(m, n));
    }

}
