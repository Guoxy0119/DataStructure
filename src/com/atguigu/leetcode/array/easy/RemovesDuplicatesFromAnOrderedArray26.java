package com.atguigu.leetcode.array.easy;

import java.util.Arrays;

/**
 * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
 * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
 * 返回 k 。
 * 判题标准:
 * 系统会用下面的代码来测试你的题解:
 * int[] nums = [...]; // 输入数组
 * int[] expectedNums = [...]; // 长度正确的期望答案
 * int k = removeDuplicates(nums); // 调用
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 * assert nums[i] == expectedNums[i];
 * }
 * 如果所有断言都通过，那么您的题解将被 通过。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2,_]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
 */
public class RemovesDuplicatesFromAnOrderedArray26 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}; // 输入数组
        int[] expectedNums = {0, 1, 2, 3, 4}; // 长度正确的期望答案

//        int[] nums = {1, 1, 2}; // 输入数组
//        int[] expectedNums = {1, 2}; // 长度正确的期望答案
        int k = removeDuplicates(nums); // 调用
        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
        System.out.println(k);
    }


    /**
     * 双指针解法
     */
    public static int removeDuplicates(int[] nums) {
        int a = 0;
        int b = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[a] == nums[b]) {
                b++;
                continue;
            }
            nums[a + 1] = nums[b];
            a++;
            b++;
        }

        System.out.println(Arrays.toString(nums));
        return a + 1;
    }

    /**
     * 双指针 0ms
     */
    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }
        return p + 1;
    }


    public static int removeDuplicates1(int[] nums) {

        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) continue;
            nums[count + 1] = nums[i + 1];
            count++;
        }

        System.out.println(Arrays.toString(nums));

        return count + 1;
    }


}
