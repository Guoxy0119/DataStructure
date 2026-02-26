package com.atguigu.huawei.pass;

import java.util.Scanner;

public class HJ106 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            String result = getResult(s);
            System.out.println(result);
        }
    }

    private static String getResult(String str) {

        String[] split = str.split("");

        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {

            sb.append(split[i]);

        }

        return sb.toString();
    }


}
