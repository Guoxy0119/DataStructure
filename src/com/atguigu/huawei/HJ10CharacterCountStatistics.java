package com.atguigu.huawei;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 对于给定的字符串，统计其中的 ASCII 码在 0 到 127 范围内的不同字符的个数。
 */
public class HJ10CharacterCountStatistics {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String input = in.nextLine();

            int result = getResult(input);
            System.out.println(result);
        }
    }

    private static int getResult(String input) {
        HashSet<Object> set = new HashSet<>();
        for (char c : input.toCharArray()) {
            if ((int) c >= 0 && (int) c <= 127) {
                set.add(c);
            }
        }
        return set.size();
    }

}
