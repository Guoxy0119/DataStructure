package com.atguigu.leetcode.array.medium;

import java.util.Arrays;

/**
 * 80-删除有序数组中的重复项  (与26类似)
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 说明：
 * 为什么返回数值是整数，但输出的答案是数组呢？
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 你可以想象内部操作如下:
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 * <p>
 * 示例 1：
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3。 不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2：
 * 输入：nums = [0,0,1,1,1,1,2,3,3]
 * 输出：7, nums = [0,0,1,1,2,3,3]
 * 解释：函数应返回新长度 length = 7, 并且原数组的前七个元素被修改为 0, 0, 1, 1, 2, 3, 3。不需要考虑数组中超出新长度后面的元素。
 */
public class RemovesDuplicatesFromOrderedArray80 {


    public static void main(String[] args) {

        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
//        int[] nums = {1, 1, 1, 2, 2, 3};
        removeDuplicates(nums);
    }

    /**
     * 大佬带注解简便写法
     */
    public int removeDuplicates1(int[] nums) {
        int k = 2; // 每个元素最多出现的次数
        if (nums.length <= k) return nums.length; // 如果数组长度小于等于 k，直接返回数组长度

        // 初始化慢指针和快指针
        int slow = k, fast = k;
        while (fast < nums.length) {
            // 如果 nums[fast] 不等于 nums[slow - k]
            // 则将 nums[fast] 复制到 nums[slow]，并将 slow 向前移动一位
            if (nums[fast] != nums[slow - k]) { //nums[slow - k] 是当前考虑的元素在新数组中的第一个可能的位置
                nums[slow] = nums[fast];
                slow++;
            }
            // 将 fast 向前移动一位，以检查下一个元素
            fast++;
        }
        // 返回新数组的长度
        return slow;
    }


    public static int removeDuplicates(int[] nums) {
        int length = 2;// 每个元素最多出现的次数

        if (nums.length <= 2) {
            return nums.length;
        }

        int slow = length;
        int fast = length;

        while (fast < nums.length) {
            if(nums[slow-length] == nums[fast]){
                fast++;
            }else {
                nums[slow] = nums[fast];
                slow++;
                fast++;
            }

        }

        System.out.println(Arrays.toString(nums));
        System.out.println(slow);

        return slow;
    }
}
