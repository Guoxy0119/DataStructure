package com.atguigu.leetcode.array.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 268. 丢失的数字
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * <p>
 * 示例 1：
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * <p>
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：2
 * 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * <p>
 * 示例 3：
 * 输入：nums = [9,6,4,2,3,5,7,0,1]
 * 输出：8
 * 解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
 * <p>
 * 示例 4：
 * 输入：nums = [0]
 * 输出：1
 * 解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。
 */
public class MissingNumber268 {


    public static void main(String[] args) {

        int[] nums = {3, 0, 1};
        int i = missingNumber(nums);
        System.out.println(i);

    }


    /**
     * 大佬异或写法
     * 作者：宫水三叶
     * 链接：https://leetcode.cn/problems/missing-number/solutions/1086545/gong-shui-san-xie-yi-ti-wu-jie-pai-xu-ji-te3s/
     */
    public static int missingNumber1(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i <= n; i++) ans ^= i;
        for (int i : nums) ans ^= i;
        return ans;
    }


    public static int missingNumber(int[] nums) {

        int index = 0;
//        List<Integer> list = new ArrayList<>();
//        for (int num : nums) {
//            list.add(num);
//        }

        //方法一：需要导入apache commons-lang3  jar
//        List<Integer> list = Arrays.asList(ArrayUtils.toObject(nums));
        //方法二：java8及以上版本
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());

        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(index)) {
                return index;
            }
            index++;

        }

        return index;
    }

}
