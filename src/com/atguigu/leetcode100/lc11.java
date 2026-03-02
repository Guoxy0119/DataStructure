package com.atguigu.leetcode100;

public class lc11 {

    public static void main(String[] args) {

        int[] ints = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(ints));

    }


    /**
     * 双指针的正确性：
     * 无论是移动短板或者长板，我们都只关注移动后的新短板会不会变长，而每次移动的木板都只有三种情况，
     * 比原短板短，比原短板长，与原短板相等；
     * 如向内移动长板，对于新的木板：
     * 1.比原短板短，则新短板更短。
     * 2.与原短板相等或者比原短板长，则新短板不变。所以，向内移动长板，一定不能使新短板变长。
     */
    public static int maxArea(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            result = Math.max(result, (right - left) * Math.min(height[left], height[right]));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return result;

    }

    // 超时！！！
//    public static int maxArea(int[] height) {
//        int result = 0;
//
//        for (int i = 0; i < height.length; i++) {
//
//            int b = 0;
//            while (b < height.length) {
//                result = Math.max(result, (b - i) * Math.min(height[b], height[i]));
//                b++;
//            }
//        }
//        return result;
//
//    }


}
