package com.atguigu.huawei.pass;

import java.util.Scanner;

/**
 * 排序
 */
public class HJ101 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) {

            String count = null;
            String element = null;
            String sort = null;
            for (int i = 0; i < 3; i++) {
                switch (i) {
                    case 0:
                        count = in.nextLine();
                        break;
                    case 1:
                        element = in.nextLine();
                        break;
                    case 2:
                        sort = in.nextLine();
                        break;
                    default:
                        break;
                }
            }

            String result = getResult(Integer.parseInt(count), element, sort);
            System.out.println(result);
        }
    }

    private static String getResult(Integer count, String element, String sort) {

        String[] split = element.split(" ");
        for (int i = 0; i < count - 1; i++) {
            for (int j = i; j < count; j++) {
                int l = Integer.parseInt(split[i]);
                int r = Integer.parseInt(split[j]);
                if (sort.equals("0")) {
                    if (l > r) {
                        String temp = split[i];
                        split[i] = split[j];
                        split[j] = temp;
                    }
                } else if (sort.equals("1")) {
                    if (l < r) {
                        String temp = split[i];
                        split[i] = split[j];
                        split[j] = temp;
                    }
                }

            }

        }

        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            sb.append(s).append(" ");
        }

        return sb.toString().trim();
    }


}
