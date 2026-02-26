package com.atguigu.huawei;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 整数与IP地址间的转换
 * <p>
 * https://blog.nowcoder.net/n/5874306c593945538926b900b568b861?f=comment
 *
 * // 注意integer会超出范围的改用long
 */
public class HJ33 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            String[] split = str.split("\\.");
            String result;
            if (split.length > 1) {
                result = get10Result(split);
            } else {
                result = getIpResult(split);
            }
            System.out.println(result);
        }
    }

    private static String getIpResult(String[] split) {
        String str = split[0];
        String binaryString = Long.toBinaryString(Long.parseLong(str));
        String format = String.format("%032d", new BigInteger(binaryString));


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < format.length(); i+= 8) {
            String substring = format.substring(i, i + 8);
            BigInteger bigInteger = new BigInteger(substring, 2);
            sb.append(bigInteger).append(".");
        }

        return sb.substring(0, sb.length() - 1);
    }

    private static String get10Result(String[] split) {
        StringBuilder sb = new StringBuilder();
        for (String str : split) {
            String binaryString = Integer.toBinaryString(Integer.parseInt(str));
            String format = String.format("%08d", Integer.parseInt(binaryString));
            sb.append(format);
        }

        return Long.toString(Long.parseLong(sb.toString(), 2));
    }

}
