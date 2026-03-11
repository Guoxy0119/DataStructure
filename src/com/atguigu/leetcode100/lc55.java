package com.atguigu.leetcode100;

public class lc55 {

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min = minStack.getMin();
        System.out.println(min);
        minStack.pop();
        int top = minStack.top();
        System.out.println(top);
        int min1 = minStack.getMin();
        System.out.println(min1);

    }


}
