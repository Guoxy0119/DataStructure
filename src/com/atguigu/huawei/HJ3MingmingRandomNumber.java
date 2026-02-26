package com.atguigu.huawei;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 对于明明生成的 个 1 到 500 之间的随机整数，你需要帮助他完成以下任务：
 * ∙删去重复的数字，即相同的数字只保留一个，把其余相同的数去掉；
 * ∙然后再把这些数从小到大排序，按照排好的顺序输出。
 * 你只需要输出最终的排序结果。
 */
public class HJ3MingmingRandomNumber {

    // TreeSet有自动排序去重的功能
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //获取个数
        int num = sc.nextInt();
        //创建TreeSet进行去重排序
        TreeSet set = new TreeSet();
        //输入
        for (int i = 0; i < num; i++) {
            set.add(sc.nextInt());
        }

        //输出
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
