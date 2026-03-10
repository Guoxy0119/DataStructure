package com.atguigu.leetcode100;

import java.util.Arrays;

public class lc189 {

    public static void main(String[] args) {

//        int[] nums = new int[]{-1, -100, 3, 99};
        int[] nums = new int[]{-1};
        int k = 2;
        rotate(nums, k);

        System.out.println(Arrays.toString(nums));

    }

    /**
     * https://leetcode.cn/problems/rotate-array/solutions/2784427/tu-jie-yuan-di-zuo-fa-yi-tu-miao-dong-py-ryfv/?envType=study-plan-v2&envId=top-100-liked
     * 三次反转
     */
    public static void rotate(int[] nums, int k) {


        k %= nums.length;

        reverse(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

        reverse(nums, 0, k - 1);
        System.out.println(Arrays.toString(nums));

        reverse(nums, k, nums.length - 1);
        System.out.println(Arrays.toString(nums));

    }

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }


    /**
     * https://leetcode.cn/problems/rotate-array/solutions/551039/xuan-zhuan-shu-zu-by-leetcode-solution-nipk/?envType=study-plan-v2&envId=top-100-liked
     * 新建一个数组
     */
    public static void rotate1(int[] nums, int k) {

        int length = nums.length;
        int[] result = new int[length];
        for (int i = 0; i < length; ++i) {
            result[(i + k) % length] = nums[i];
        }


        /**
         * 3. 这里是关键：将局部变量 nums 重新指向了 result
         * 4. 这里打印的是局部变量 nums 现在指向的 result 数组，所以看起来是正确的
         * 5. 方法结束，局部变量 nums 销毁。外部 main 方法中的 nums 引用从未被改变
         */
//        nums = result;
//        nums = Arrays.copyOf(result, length);


        // 正确的做法：将结果数组 result 的元素复制回原数组 nums
        for (int i = 0; i < length; i++) {
            nums[i] = result[i];
        }
        // 或者
//        System.arraycopy(result, 0, nums, 0, length);


        System.out.println(Arrays.toString(nums));

    }


}
