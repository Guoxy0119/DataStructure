package com.atguigu.huawei;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 密码验证合格程序
 * <p>
 * https://www.nowcoder.com/practice/184edec193864f0985ad2684fbc86841?tpId=37&tqId=21243&rp=1&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
 */
public class HJ20 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String input = in.nextLine();
            String result = getResult(input);
            System.out.println(result);
        }
    }

    //https://blog.nowcoder.net/n/9dae3f247d1d483497281ef071539a40?f=comment
    //https://blog.nowcoder.net/n/9513522e24f643a7a6de690e795acfc3?f=comment
    private static String getResult(String input) {

        // 长度大于8
        if (input.length() < 8) {
            return "NG";
        }

        // 必须包含大写字母、小写字母、数字、特殊字符中的至少三种
        if (getRegex(input)) {
            return "NG";
        }

        // 不能分割出两个独立的、长度大于 2 的连续子串，使得这两个子串完全相同
        if (getSame(input, 0, 3)) {
            return "NG";
        }

        return "OK";
    }

    private static boolean getSame(String str, int l, int r) {
        if (r >= str.length()) {
            return false;
        }
        if (str.substring(r).contains(str.substring(l, r))) {
            return true;
        } else {
            return getSame(str, l + 1, r + 1);
        }
    }

    private static Boolean getRegex(String str) {
        int count = 0;
        Pattern p1 = Pattern.compile("[A-Z]");
        if (p1.matcher(str).find()) {
            count++;
        }
        Pattern p2 = Pattern.compile("[a-z]");
        if (p2.matcher(str).find()) {
            count++;
        }
        Pattern p3 = Pattern.compile("[0-9]");
        if (p3.matcher(str).find()) {
            count++;
        }
        Pattern p4 = Pattern.compile("[^a-zA-Z0-9]");
        if (p4.matcher(str).find()) {
            count++;
        }
        if (count >= 3) {
            return false;
        } else {
            return true;
        }
    }

}
