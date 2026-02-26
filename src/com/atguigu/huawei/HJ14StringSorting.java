package com.atguigu.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class HJ14StringSorting {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int total = in.nextInt();

        String[] strings = new String[total];
        for (int i = 0; i < total; i++) {
            strings[i] = in.next();
        }

        Arrays.stream(strings).sorted().forEach(System.out::println);
    }
}
