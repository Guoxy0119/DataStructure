package com.atguigu.leetcode.array;

import com.atguigu.leetcode.NumArray;
import com.atguigu.leetcode.NumArrayNew;

/**
 * https://leetcode.cn/problems/range-sum-query-immutable/description/
 */
public class TheRegionAndTheSearchArrayAreImmutable303 {


    public static void main(String[] args) {

        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        NumArrayNew numArrayNew = new NumArrayNew(nums);
        int i = numArrayNew.sumRange(0, 2);
        System.out.println(i);

    }

}
