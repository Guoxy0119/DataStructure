package com.atguigu.video.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {

    public static void main(String[] args) {


        /**
         * 完成将一个中缀表达式转换成后缀表达式的功能
         * 说明
         * 将一个中缀表达式转成后缀表达式
         * 1、1+((2+3)×4)-5 => 转成 1 2 3 + 4 × + 5 –
         * 2、因为直接对str 进行操作，不方便，因此 先将 "1+((2+3)×4)-5" =》 中缀的表达式对应的List
         * 3. 将得到的中缀表达式对应的List => 后缀表达式对应的List
         */
        String expression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println("中缀表达式对应的List" + infixExpressionList);
        List<String> suffixExpressionList = parseSuffixExpressionList(infixExpressionList);
        System.out.println("后缀表达式对应的List" + suffixExpressionList);

        System.out.printf("expression = %d", calculate(suffixExpressionList));


/*        //先定义个逆波兰表达式
        // (3+4)×5-6 => 3 4 + 5 × 6 -
        // 4*5-8+60+8/2 => 4 5 * 8 - 60 + 8 2 / + // 76
        // 说明为了方便，逆波兰表达式的数字和符号使用空格隔开
        String suffixExpression = "30 4 + 5 * 6 -";
        //思路
        //1.先将 "3 4 + 5 × 6 -" => 放到ArrayList中
        //2.将ArrayList 传递给一个方法，遍历 ArrayList 配合栈 完成计算
        List<String> rpnList = getListString(suffixExpression);
        System.out.println("rpnList=" + rpnList);

        int res = calculate(rpnList);
        System.out.println("计算的结果是=" + res);*/

    }

    /**
     * 3. 将得到的中缀表达式对应的List => 后缀表达式对应的List
     */
    public static List<String> parseSuffixExpressionList(List<String> ls) {
        //定义两个栈
        Stack<String> s1 = new Stack<>();//符号栈
        //说明：因为s2这个栈在整个转换过程中，没有pop操作，而且后面还需要逆序输出，所以直接试用List替代stack   （用s2也可以,最后new StringBuilder(str).reversed().toString()）
        List<String> s2 = new ArrayList<>();

        //遍历ls
        for (String item : ls) {
            //如果是一个数，就加入s2
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                // 如果是右括号”）“，则依次弹出s1栈顶的运算符，压入s2，直到遇到左括号为止，此时将这一对括号丢弃。
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();//!!!将”（“弹出s1，消除小括号

            } else {
                //当item的优先级小于等于栈顶运算符的优先级时，将s1栈顶的运算符弹出并加入到s2中，再次转到4.1与s1中新的栈顶运算符相比较
                //比较优先级高低
//                int v1 = Operation.getValue(s1.peek());//s1栈顶的优先级
//                int v2 = Operation.getValue(item);//当前符号的优先级
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                // 还需要将item压入栈
                s1.push(item);
            }
        }

        //将s1中剩余的运算符依次弹出并添加到s2
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }

        //注意！因为是存放到List中，有序，因此按顺序输出就是对应的后缀表达式对应的List
        return s2;

    }


    /**
     * 完成将一个中缀表达式转换成后缀表达式的功能
     * 说明
     * 将一个中缀表达式转成后缀表达式
     * 1、1+((2+3)×4)-5 => 转成 1 2 3 + 4 × + 5 –
     * 2、因为直接对str 进行操作，不方便，因此 先将 "1+((2+3)×4)-5" =》 中缀的表达式对应的List
     */
    public static List<String> toInfixExpressionList(String s) {
        //定义一个List，存放中缀表达式对应的内容
        List<String> ls = new ArrayList<>();
        int i = 0; // 这是一个指针，用于遍历中缀表达式字符串
        String str;//对多位数的拼接
        char c;//每遍历到一个字符，就放到c

        do {
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                //如果c是一个非数字，我需要加入到ls
                ls.add(c + "");
                i++;//i后移

            } else {
                //如果是一个数，需要考虑多位数
                str = "";//先将str置空 '0'[48] ->'9'[57]
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;//拼接
                    i++;

                }
                ls.add(str);
            }


        } while (i < s.length());

        return ls;

    }


    //将一个逆波兰表达式，依次将数据和运算符 放入到ArrayList中
    public static List<String> getListString(String suffixExpression) {
        //将 suffixExpression 分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }


    //完成对逆波兰表达式的运算
    /*
    1)从左至右扫描，将3和4压入堆栈；
    2)遇到+运算符，因此弹出4和3（4为栈顶元素，3为次顶元素），计算出3+4的值，得7，再将7入栈；
    3)将5入栈；
    4)接下来是×运算符，因此弹出5和7，计算出7×5=35，将35入栈；
    5)将6入栈；
    6)最后是-运算符，计算出35-6的值，即29，由此得出最终结果
     */
    public static int calculate(List<String> ls) {
        //创建一个栈，只需要一个栈即可
        Stack<String> stack = new Stack<>();
        //遍历 ls
        for (String item : ls) {
            //这里使用正则表达式来取出数
            if (item.matches("\\d+")) { // 匹配的是多位数
                //入栈
                stack.push(item);
            } else {
                //pop出两个数，并运算，再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                //把运算结果入栈
                stack.push("" + res);
            }
        }
        //最后留在stack中的数据是运算结果
        return Integer.parseInt(stack.pop());
    }


}
