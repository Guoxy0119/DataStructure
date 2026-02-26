package com.atguigu.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 对于给定的十六进制数，输出其对应的十进制表示。
 */
public class HJ5ConversionOfNumberSystems {

//    public static void main(String[] args) throws Exception {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNextLine()) {
//            String s = sc.nextLine();
//            System.out.println(Integer.parseInt(s.substring(2, s.length()), 16));
//        }
//    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            int result = getResult(s);
            System.out.println(result);
        }
    }

    private static Map<Character, Integer> map = new HashMap<Character, Integer>() {
        {
            put('0', 0);
            put('1', 1);
            put('2', 2);
            put('3', 3);
            put('4', 4);
            put('5', 5);
            put('6', 6);
            put('7', 7);
            put('8', 8);
            put('9', 9);
            put('A', 10);
            put('B', 11);
            put('C', 12);
            put('D', 13);
            put('E', 14);
            put('F', 15);
            put('a', 10);
            put('b', 11);
            put('c', 12);
            put('d', 13);
            put('e', 14);
            put('f', 15);
        }
    };

    public static int getResult(String s) {
        int result = 0;
        String substring = s.substring(2);
        for (char c : substring.toCharArray()) {
            result = result * 16 + map.get(c);
        }
        return result;
    }

}


