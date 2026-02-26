package com.atguigu.huawei.pass;

import java.util.*;

/**
 * 删除字符串中出现次数最少的字符
 * 对于给定的仅由小写字母构成的字符串，删除字符串中出现次数最少的字符。输出删除后的字符串，字符串中其它字符保持原来的顺序。
 * 特别地，若有多个字符出现的次数都最少，则把这些字符都删除。
 */
public class HJ23 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            String result = getResult(str);
            System.out.println(result);
        }
    }

    private static String getResult(String str) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //找到数量最少的字符数量
//        Collection<Integer> values = map.values();
//        Integer min = Collections.min(values);


        int min = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (min == 0) {
                min = value;
            } else {
                min = Math.min(min, value);
            }
        }

        String result = str;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == min) {
                result = result.replace(entry.getKey().toString(), "");
            }

        }

        return result;
    }
}
