package com.atguigu.huaweiQuestionBank;

import java.util.*;

/**
 * 题目描述：有一个键盘有2个按键失灵了，按下这些键时会连续输出其他键对应的字符两次。具体如下：
 * -按下j键一次，屏幕上显示uu（两个连续的u），按下b键一次，屏幕上显示tt（两个连续的t）
 * -u键和t键是好的，按下u键一次时，屏幕只会显示一次u（正常按键）；按下t键一次时，屏幕只会显示一次t（正常按键)
 * -假定屏幕上连续显示两个t一定是按了一次b键，而不是两次t键；假定按键t之后不会紧接着按键b，即tttt转义为两个b，而不可能是tbt；u和j同样适用该规则
 * -其它按键也都正常工作
 * 为了方便维修，给定一串屏幕上输出的字符串，维修师傅要求按照按键次数降序输出，次数相同的按键按照对应字符的升序排序（失灵按键以原对应字
 * 符来排序），只统计按键次数大于0的按键
 * 同时维修师傅要求输出时需要进行一次转义（字符映射），规则如下
 * -按键0~9，直接以数字0~9进行输出
 * 按键a~z，以10~35进行输出
 * ------------
 * 输入
 * 一个字符串s，只包含小写字母和数字s的长度不超过500（s中不包含b和字母)
 * 输出
 * （按键转义后的值，按键次数)构成结果对，所有按键的结果对按照按键次数降序排列（输出实际是二维数组，第二维固定长度2）
 * ------------
 * 补充说明：按键范围只包括：小写字母a~z和数字0~9。
 * 转义表：
 * '0'->0,  1->1  ,...,  '9'->9
 * 'a'>10 , 'b'->11,  ....,  'Z'-> 35
 * <p>
 * 以下是针对题目要求的多种编程语言 实现。每个实现都遵循以下逻辑：
 * <p>
 * 解析输入字符串，还原按键序列：
 * 遇到连续"tt"时记录为按一次'b'键
 * 遇到连续"uu"时记录为按一次'j'键
 * 单个't'或'u'记录为对应按键
 * 其他字符直接记录为对应按键
 * 统计按键次数并转义：
 * 数字字符转义为对应数字（0-9）
 * 字母字符转义为10-35（a->10, b->11, ..., z->35）
 * 过滤按键次数>0的项
 * 排序：按键次数降序，次数相同时按键转义值升序
 * 输出二维数组[转义值, 按键次数]
 */
public class 键盘失灵 {

    public static void main(String[] args) {

        String s = "sadtthlauusde";
        List<int[]> solve = solve(s);
        for (int[] arr : solve) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static List<int[]> solve(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        int i = 0, n = s.length();
        while (i < n) {
            char c = s.charAt(i);
            if (c == 't') {
                if (i + 1 < n && s.charAt(i + 1) == 't') {
                    countMap.put('b', countMap.getOrDefault('b', 0) + 1);
                    i += 2;
                } else {
                    countMap.put('t', countMap.getOrDefault('t', 0) + 1);
                    i++;
                }
            } else if (c == 'u') {
                if (i + 1 < n && s.charAt(i + 1) == 'u') {
                    countMap.put('j', countMap.getOrDefault('j', 0) + 1);
                    i += 2;
                } else {
                    countMap.put('u', countMap.getOrDefault('u', 0) + 1);
                    i++;
                }
            } else {
                countMap.put(c, countMap.getOrDefault(c, 0) + 1);
                i++;
            }
        }

        List<int[]> result = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            char key = entry.getKey();
            int escapeVal = (key >= '0' && key <= '9') ? (key - '0') : (10 + (key - 'a'));
            result.add(new int[]{escapeVal, entry.getValue()});
        }

        result.sort((a, b) -> a[1] == b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(b[1], a[1]));
        return result;
    }
}
