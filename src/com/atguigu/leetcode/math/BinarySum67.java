package com.atguigu.leetcode.math;

/**
 * 67.二进制求和
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 * 示例 1：
 * 输入:a = "11", b = "1"
 * 输出："100"
 * <p>
 * 示例 2：
 * 输入：a = "1010", b = "1011"
 * 输出："10101"
 * <p>
 * 提示：
 * 1 <= a.length, b.length <= 104
 * a 和 b 仅由字符 '0' 或 '1' 组成
 * 字符串如果不是 "0" ，就不含前导零
 */
public class BinarySum67 {

    public static void main(String[] args) {

        String a = "1010";
        String b = "1011";

        addBinary1(a, b);


        // int num1 = a.charAt(i) - '0'; // 将字符转换为对应的数字
        // int num1 = Character.getNumericValue(a.charAt(i));

    }


    /**
     * 大佬写法
     * 作者：画手大鹏
     * 链接：https://leetcode.cn/problems/add-binary/solutions/9617/hua-jie-suan-fa-67-er-jin-zhi-qiu-he-by-guanpengch/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static String addBinary1(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            ca = sum / 2;
        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }


    /**
     * AI优化后写法
     */
    public static String addBinary2(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0; // Initialize the carry

        // Initialize pointer positions to the end of each binary string
        int i = a.length() - 1;
        int j = b.length() - 1;

        // Loop until both strings are fully processed
        while (i >= 0 || j >= 0 || carry > 0) {
            // Take the next digit from each string
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i--) - '0'; // Convert char to int and add
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0'; // Convert char to int and add
            }

            // Calculate carry and the value to add to result
            carry = sum / 2; // Calculate carry
            result.append(sum % 2); // Append current bit (0 or 1)
        }

        // The result needs to be reversed as we've built it backwards
        return result.reverse().toString();
    }

    /**
     * 我的写法
     */
    public static String addBinary(String a, String b) {

        int maxLength = Math.max(a.length(), b.length());
        if (a.length() != maxLength) {
            StringBuilder sb = new StringBuilder();
            //java 11 提示 可以使用string.repeat的方法代替for循环
            for (int i = 0; i < maxLength - a.length(); i++) {
                sb.append("0");
            }
            sb.append(a);
            a = sb.toString();
        } else if (b.length() != maxLength) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < maxLength - b.length(); i++) {
                sb.append("0");
            }
            sb.append(b);
            b = sb.toString();
        }

        int carry = 0;// 进位
        StringBuilder result = new StringBuilder();
        for (int i = maxLength - 1; i >= 0; i--) {

            if (a.charAt(i) - '0' + b.charAt(i) - '0' + carry > 1) {
                result.insert(0, a.charAt(i) - '0' + b.charAt(i) - '0' + carry == 3 ? "1" : "0");
                carry = 1;
            } else {
                result.insert(0, a.charAt(i) - '0' + b.charAt(i) - '0' + carry);
                carry = 0;
            }
        }
        if (carry != 0) {
            result.insert(0, carry);
        }
        System.out.println(result.toString());
        return result.toString();
    }
}
