package com.atguigu.huawei;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * 合并表记录
 * 数据表中，一条记录包含表索引和数值两个值。请对表索引相同的记录进行合并（即将相同索引的数值进行求和运算），随后按照索引值的大小从小到大依次输出。
 */
public class HJ8 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < count; i++) {

            int k = in.nextInt();
            int v = in.nextInt();

            map.merge(k, v, Integer::sum);
        }
        map.forEach((key, value) -> System.out.println(key + " " + value));
    }

}
