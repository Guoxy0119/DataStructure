package com.atguigu.huawei;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 成绩排序
 * https://blog.nowcoder.net/n/146810c1e92740118632d21fcf5d5ecb?f=comment
 */
public class HJ68GradeRanking {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int sort = in.nextInt();

        // 数组与map之间用顺序关联，即map.key = 数组[i][0]的值
        int[][] score = new int[count][2];
        HashMap<Integer, String> nameMap = new HashMap<>();
        for (int i = 0; i < count; i++) {
            String name = in.next();
            int grade = in.nextInt();
            score[i][0] = i;
            score[i][1] = grade;
            nameMap.put(i, name);
        }

        // 排序
/*
// 这个这段代码中的排序没有生效，主要原因在于使用了 Stream 的 sorted() 方法，它不会修改原数组，而是返回一个新的有序流。如果不将流的结果收集起来并重新赋值给原数组，原数组 score 的内容不会有任何变化。

//这个写法是正确的
score = Arrays.stream(score)
        .sorted((o1, o2) -> {
            if (sort == 1) {
                return o1[1] - o2[1];
            } else {
                return o2[1] - o1[1];
            }
        })
        .toArray(int[][]::new);

        //这个写法是错误的
        Arrays.stream(score).sorted(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (sort == 1) {
                    //1 表示按成绩升序
                    return o1[1] - o2[1];
                } else if (sort == 0) {
                    //0 表示按成绩降序，
                    return o2[1] - o1[1];
                }
                return 0;
            }
        });
*/

        Arrays.sort(score, (o1, o2) -> {
            if (sort == 1) {
                return o1[1] - o2[1]; // 升序
            } else {
                return o2[1] - o1[1]; // 降序
            }
        });


        // 打印
        for (int i = 0; i < count; i++) {
            System.out.println(nameMap.get(score[i][0]) + " " + score[i][1]);
        }


    }

}
