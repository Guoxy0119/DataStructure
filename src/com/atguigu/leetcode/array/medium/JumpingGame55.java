package com.atguigu.leetcode.array.medium;

/**
 * 55-跳跃游戏
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * <p>
 * 示例 2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 */
public class JumpingGame55 {

    public static void main(String[] args) {

        int[] nums = {3, 0, 8, 2, 0, 0, 1};
//        int[] nums = {0, 2, 3};
//        int[] nums = {0};
//        int[] nums = {2, 3, 1, 1, 4};
//        int[] nums = {3, 2, 1, 0, 4};
        boolean b = canJump(nums);
        System.out.println(b);
    }


    /**
     * 大佬写法
     * 作者：灵茶山艾府
     * 链接：https://leetcode.cn/problems/jump-game/solutions/2798996/liang-chong-li-jie-fang-shi-wei-hu-zui-y-q67s/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static boolean canJump(int[] nums) {
        int mx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > mx) { // 无法到达 i
                return false;
            }
            mx = Math.max(mx, i + nums[i]); // 从 i 最右可以跳到 i + nums[i]
        }
        return true;


    }

}
