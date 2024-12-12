package com.atguigu.leetcode.array.medium;

import java.util.Arrays;

/**
 * 189-轮转数组
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * <p>
 * 示例 2:
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 */
public class RotatingArray189 {


    public static void main(String[] args) {

//        int[] nums = {1, 2, 3, 4, 5, 6, 7};
//        int[] nums = {-1,-100,3,99};
        int[] nums = {-1};
        int k = 2;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));

    }

    /**
     * 大佬写法
     * 根据题意，如果使用多余数组存储空间，会导致空间复杂度为 n，所以在这里，我们可以使用常量级的空间复杂度解法：数组翻转。
     * 思路如下：
     * 首先对整个数组实行翻转，这样子原数组中需要翻转的子数组，就会跑到数组最前面。
     * 这时候，从 k 处分隔数组，左右两数组，各自进行翻转即可。
     * 作者：御三五 🥇
     * 链接：https://leetcode.cn/problems/rotate-array/solutions/683855/shu-zu-fan-zhuan-xuan-zhuan-shu-zu-by-de-5937/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static void rotate(int[] nums, int k) {
        //作用是将 k 对数组长度取模，即取余操作。这样做的结果是，无论 k 的值是多少，它都会被限制在 0 到 nums.size() - 1（数组长度减一）的范围内。
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }


    /**
     * 我的写法
     */
    public static void rotate1(int[] nums, int k) {
        if (k > nums.length) {
            k = k % nums.length;//!!!我这里本来想用减法，代码提示给了%  妙啊
        }

        int length = nums.length;

        int[] result = new int[length];
        for (int i = 0; i < nums.length; i++) {

            if (i + k > nums.length - 1) {
                result[i + k - nums.length] = nums[i];
            } else {
                result[i + k] = nums[i];
            }
        }

//        nums = result;  //这样写最后返回的还是原始的nums
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }

}
