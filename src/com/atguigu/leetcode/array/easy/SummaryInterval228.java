package com.atguigu.leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 汇总区间
 * 给定一个  无重复元素 的 有序 整数数组 nums 。
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 * <p>
 * 示例 1：
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * <p>
 * 示例 2：
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 */
public class SummaryInterval228 {


    public static void main(String[] args) {

        int[] nums = {0, 1, 2, 4, 5, 7};
        List<String> strings = summaryRanges(nums);
        System.out.println(strings);

    }

    /**
     * 大神耗时更短
     */
    public static List<String> summaryRanges1(int[] nums) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(Integer.toString(nums[high]));
            }
            ret.add(temp.toString());
        }
        return ret;
    }


    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        if (nums.length == 0) return result;  // 处理空数组的情况

        int start = nums[0];  // 区间的起始点

        for (int i = 1; i < nums.length; i++) {
            // 如果当前数与前一个数不是连续的
            if (nums[i] != nums[i - 1] + 1) {
                // 将当前区间添加到结果中
                if (start == nums[i - 1]) {
                    result.add(String.valueOf(start));  // 只有一个数字
                } else {
                    result.add(start + "->" + nums[i - 1]);  // 区间形式
                }
                start = nums[i];  // 更新起始点
            }
        }

        // 处理最后一个区间
        if (start == nums[nums.length - 1]) {
            result.add(String.valueOf(start));
        } else {
            result.add(start + "->" + nums[nums.length - 1]);
        }

        return result;
    }


}
