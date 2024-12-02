package com.atguigu.leetcode.array.easy;

import java.util.HashSet;

/**
 * 219. 存在重复元素 II
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。
 * 如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 */
public class DuplicateElementExists219 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;


        boolean b = containsNearbyDuplicate(nums, k);
        System.out.println(b);
    }

    /**
     * 思路
     * 标签：哈希
     * 维护一个哈希表，里面始终最多包含 k 个元素，当出现重复值时则说明在 k 距离内存在重复元素
     * 每次遍历一个元素则将其加入哈希表中，如果哈希表的大小大于 k，则移除最前面的数字
     * 时间复杂度：O(n)，n 为数组长度
     * <p>
     * 作者：画手大鹏
     * 链接：https://leetcode.cn/problems/contains-duplicate-ii/solutions/13564/hua-jie-suan-fa-219-cun-zai-zhong-fu-yuan-su-ii-by/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }


}
