package com.atguigu.leetcode.string.easy;

/**
 * 罗马数字转整数
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。
 * <p>
 * 示例 1:
 * 输入: s = "III"
 * 输出: 3
 * <p>
 * 示例 2:
 * 输入: s = "IV"
 * 输出: 4
 * <p>
 * 示例 3:
 * 输入: s = "IX"
 * 输出: 9
 * <p>
 * 示例 4:
 * 输入: s = "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * <p>
 * 示例 5:
 * 输入: s = "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class RomanNumeralsToWholeNumbers13 {

    public static void main(String[] args) {

//        String str = "III";
        String str = "MCMXCIV";
        int i = romanToInt(str);
        System.out.println(i);

    }


    /**
     * 大神解法
     * 一言蔽之，把一个小值放在大值的左边，就是做减法，否则为加法。
     */
    public static int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private static int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }


    public static int romanToInt1(String s) {
        if (s == null) {
            return 0;
        }

        s = s.replace("IV", "A");
        s = s.replace("IX", "B");
        s = s.replace("XL", "E");
        s = s.replace("XC", "F");
        s = s.replace("CD", "G");
        s = s.replace("CM", "H");


        int res = 0;

        String[] split = s.split("");
        for (String str : split) {

            res = romanParse(str, res);

        }

        return res;
    }

    public static int romanParse(String str, int res) {
        switch (str) {
            case "I":
                res += 1;
                break;
            case "V":
                res += 5;
                break;
            case "X":
                res += 10;
                break;
            case "L":
                res += 50;
                break;
            case "C":
                res += 100;
                break;
            case "D":
                res += 500;
                break;
            case "M":
                res += 1000;
                break;
            case "A":
                res += 4;
                break;
            case "B":
                res += 9;
                break;
            case "E":
                res += 40;
                break;
            case "F":
                res += 90;
                break;
            case "G":
                res += 400;
                break;
            case "H":
                res += 900;
                break;


            default:
                break;
        }

        return res;
    }

}
