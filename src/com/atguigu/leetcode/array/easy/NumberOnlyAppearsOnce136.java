package com.atguigu.leetcode.array.easy;

/**
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 * <p>
 * 示例 1 ：
 * 输入：nums = [2,2,1]
 * 输出：1
 * <p>
 * 示例 2 ：
 * 输入：nums = [4,1,2,1,2]
 * 输出：4
 * <p>
 * 示例 3 ：
 * 输入：nums = [1]
 * 输出：1
 */
public class NumberOnlyAppearsOnce136 {
    public static void main(String[] args) {

        int[] nums = {4, 1, 2, 1, 2};
        int i = singleNumber(nums);
        System.out.println(i);

    }


    /**
     * 位运算
     */
    public static int singleNumber(int[] nums) {

        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;

    }

}
