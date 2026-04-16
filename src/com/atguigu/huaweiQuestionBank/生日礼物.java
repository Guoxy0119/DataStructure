package com.atguigu.huaweiQuestionBank;

import java.util.*;

/**
 * 题目描述
 * 小明在一个充满人文关怀的公司上班，公司每个月都要为该月生日的同事送一份生日小礼物，该事项由小明负责，请帮助小明统计某一月份应该准备多少礼物，重复录入的员工生日以最后一次录入结果为准，请不要重复统计，避免浪费。
 * 输入描述
 * 参数1，要发放礼物的月份，取值1到12。
 * 参数2，员工列表。
 * 参数3，员工生日日期列表，该列表和员工列表中的数据对应存在一-对应关系，长度一致。
 * 输出描述
 * 该月份要准备的礼品个数。
 * 补充说明
 * 1.小明公司的员工人数不超过100人。
 * 2.员工姓名是字母和数字的组合，姓名长度大于0，小于16字节。
 * 3.日期录入格式统一采用 Year/Month/Day，Year 长度为4,Month和Day长度为11到22，系统保证录入日期为合法日期。4.不考虑同名多位员工的情况，名字一致即可认为是同一员工(在生产系统会通过工号区分，本系统简化处理)
 */
public class 生日礼物 {


    public static int calGiftNum(int month, String[] names, String[] birthdays) {
        Map<String, Integer> nameMonth = new HashMap<>();

        for (int i = 0; i < names.length; i++) {
            String currentName = names[i];
            String currentBirthday = birthdays[i];
            // 生日格式：xxxx/xx/xx，取月份
            int m = Integer.parseInt(currentBirthday.split("/")[1]);
            nameMonth.put(currentName, m);
        }

        // 统计
        int count = 0;
        for (int m : nameMonth.values()) {
            if (m == month) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int month = sc.nextInt();
        sc.nextLine(); // 吃掉换行

        String name = sc.nextLine();
        String birthday = sc.nextLine();

        String[] names = name.split(" ");
        String[] birthdays = birthday.split(" ");

        int res = calGiftNum(month, names, birthdays);
        System.out.println(res);
    }

}
