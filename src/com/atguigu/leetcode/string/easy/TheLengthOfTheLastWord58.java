package com.atguigu.leetcode.string.easy;

/**
 * 最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串
 * <p>
 * 示例 1：
 * 输入：s = "Hello World"
 * 输出：5
 * 解释：最后一个单词是“World”，长度为 5。
 * <p>
 * 示例 2：
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 解释：最后一个单词是“moon”，长度为 4。
 * <p>
 * 示例 3：
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 * 解释：最后一个单词是长度为 6 的“joyboy”。
 */
public class TheLengthOfTheLastWord58 {
    public static void main(String[] args) {

        String s = "   fly me   to   the moon  ";
        int i = lengthOfLastWord(s);
        System.out.println(i);

    }


    /**
     * 大神解法
     * 从字符串的末尾开始向前遍历，遇到非空格字符就增加长度计数，
     * 直到遇到空格并且长度计数不为0时停止，这样就找到了最后一个单词的长度。
     */
    public static int lengthOfLastWord(String s) {

        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                res++;
            } else if (res != 0 && s.charAt(i) == ' ') {
                return res;
            }
        }

        return res;
    }

    public static int lengthOfLastWord1(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }

        s = s.trim();
        String[] split = s.split(" ");
        String res = split[split.length - 1];
        res = res.trim();

        return res.length();

    }
}
