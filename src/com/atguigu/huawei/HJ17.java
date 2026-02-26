package com.atguigu.huawei;

import java.util.Scanner;

/**
 * 坐标移动
 */
public class HJ17 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String input = in.nextLine();
            String result = move(input);
            System.out.println(result);
        }
    }

    private static String move(String input) {
        int x = 0;
        int y = 0;
        String[] split = input.split(";");
        for (String s : split) {
            // 不满足题目给定坐标规则
//            if(!s.matches("[WASD][0-9]{1,2}")){
//                continue;
//            }
//            int step = Integer.parseInt(s.substring(1));


            int step = 0;
            try {
                String substring = s.substring(1);
                if (substring.length() >= 3) {
                    continue;
                }
                step = Integer.parseInt(substring);
            } catch (Exception e) {
                continue;
            }
            if (step <= 0 || step >= 100) {
                continue;
            }

            switch (s.substring(0, 1)) {
                case "W":
                    y += step;
                    break;
                case "A":
                    x -= step;
                    break;
                case "S":
                    y -= step;
                    break;
                case "D":
                    x += step;
                    break;
                default:
                    break;
            }
        }
        return x + "," + y;
    }
}
