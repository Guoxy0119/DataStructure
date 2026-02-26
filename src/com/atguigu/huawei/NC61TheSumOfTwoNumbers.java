package com.atguigu.huawei;

import java.util.Arrays;

/**
 * 给出一个整型数组 numbers 和一个目标值 target，请在数组中找出两个加起来等于目标值的数的下标，返回的下标按升序排列。
 * （注：返回的数组下标从1开始算起，保证target一定可以由数组里面2个数字相加得到）
 */
public class NC61TheSumOfTwoNumbers {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param numbers int整型一维数组
     * @param target  int整型
     * @return int整型一维数组
     */
    public static int[] twoSum(int[] numbers, int target) {


        for (int i = 0; i < numbers.length; i++) {
            int a = i+1;
            int number1 = numbers[i];

            while (a <= numbers.length-1) {
                int number2 = numbers[a];
                if (number1 + number2 == target) {
                    return new int[]{i + 1, a + 1};
                }
                a++;
            }


        }

        return null;
    }


    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{11, 15, 2, 7}, 9);
        System.out.println(Arrays.toString(ints));
    }

}
