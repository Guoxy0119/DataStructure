package com.atguigu.huawei;

import java.util.Stack;

/**
 * 括号最大嵌套深度
 * 给定 有效括号字符串 s，返回 s 的 嵌套深度。嵌套深度是嵌套括号的 最大 数量。
 * https://leetcode.cn/problems/maximum-nesting-depth-of-the-parentheses/description/
 */
public class leetcode1614MaximumDepthOfParenthesesNesting {


    public static void main(String[] args) {

        String str = "()(())((()()))";
        int res = maxDepth(str);
        System.out.println(res);

    }

    public static int maxDepth(String s) {

        int res = 0;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    stack.push('(');
                    break;
                case ')':
                    res = Math.max(res, stack.size());
                    stack.pop();
                    break;
            }

        }
        return res;

    }


}
