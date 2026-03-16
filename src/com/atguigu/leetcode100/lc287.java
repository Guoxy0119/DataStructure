package com.atguigu.leetcode100;

import java.util.HashMap;

public class lc287 {

    public static void main(String[] args) {

        int[] nums = {1, 3, 4, 2, 2};
        int duplicate = findDuplicate(nums);
        System.out.println(duplicate);

    }


    // 大佬解法
    //https://leetcode.cn/problems/find-the-duplicate-number/solutions/58841/287xun-zhao-zhong-fu-shu-by-kirsche
    public static int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        int pre1 = 0;
        int pre2 = slow;
        while (pre1 != pre2) {
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;

    }


    public static int findDuplicate1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.getOrDefault(num, 0) != 0) {
                return num;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return 0;
    }
}
