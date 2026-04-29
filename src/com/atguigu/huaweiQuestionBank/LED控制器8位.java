package com.atguigu.huaweiQuestionBank;

import java.util.*;

/**
 * 有一个8位LED控制器√，包含8个LED灯 (编号0-7)，初始状态全灭，用8位二进制表示为:00000000。控制器可以接收以下三种指令：
 * Lx:L表示点亮操作，x表示LED的编号(0-7)，操作得到的结果是:点亮第x个LED灯，把状态设为1。
 * Dx:D表示熄灭操作，x表示LED的编号(0-7)，操作得到的结果是:熄灭第x个LED灯，把状态设为0。
 * Tx:T表示切换操作，x表示LED的编号(0-7)，操作得到的结果是:切换第x个LED灯的状态，若状态为0则变为1，为1则变为0。
 * 现在给定一组指令字符串 √(0<=长度<=1000)，按照顺序解析并执行所有的指令，并返回最终8位二进制对应的整数值。列如：“L0L1L2T1“操作表示:点亮LED0，点亮LED1，点亮LED2，切换LED1，最终二进制☑ 00000101,应整数5。
 * 输入描述
 * 给定一组指令字符串(0<=长度<=1000)
 * 输出描述
 * 返回最终8位二进制对应的整数值
 */
public class LED控制器8位 {


    public static int controlInstruct(String instruct) {
        int[] bits = new int[8];

        for (int i = 0; i < instruct.length(); i += 2) {
            char c = instruct.charAt(i);
            int pos = instruct.charAt(i + 1) - '0';

            // 点亮变为1
            if (c == 'L') {
                bits[pos] = 1;
                // 熄灭
            } else if (c == 'D') {
                bits[pos] = 0;
                // 切换
            } else if (c == 'T') {
                bits[pos] ^= 1;
            }
        }

        int res = 0;
        for (int i = 7; i >= 0; i--) {
            res = res * 2 + bits[i];
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int res = controlInstruct(input);
        System.out.println(res);
    }

}
