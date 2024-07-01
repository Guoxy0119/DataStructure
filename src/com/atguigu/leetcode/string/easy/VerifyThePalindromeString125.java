package com.atguigu.leetcode.string.easy;

/**
 * 验证回文串
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * 字母和数字都属于字母数字字符。
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串。
 * <p>
 * 示例 2：
 * 输入：s = "race a car"
 * 输出：false
 * 解释："raceacar" 不是回文串。
 * <p>
 * 示例 3：
 * 输入：s = " "
 * 输出：true
 * <p>
 * 解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
 * 由于空字符串正着反着读都一样，所以是回文串。
 */
public class VerifyThePalindromeString125 {

    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";
//        String s = " ";
        boolean palindrome = isPalindrome(s);
        System.out.println(palindrome);

    }

    /**
     * 评论区大佬写的，效率更高
     * java.lang.Character.isLetterOrDigit(char ch) 这个方法确定指定的字符是否为字母或数字。字符被认为是字母或数字，如果字符是字母或数字则此方法返回true，否则为false。
     */
    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            i++;
            j--;
        }
        return true;

    }


    public static boolean isPalindrome1(String s) {
        String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if (str.isEmpty()) return true;

//        int p1 = 0;
        int p2 = str.length() - 1;

        String[] strs = str.split("");

        for (int i = 0; i < str.length() / 2; i++) {
            //无论是奇数个还是偶数个  都/2即可  奇数剩下单独那一个不需要判断
            if (!strs[i].equals(strs[p2])) {
                return false;
            }
            p2--;
        }
        return true;
    }


}
