package com.atguigu.leetcode;

/**
 * https://leetcode.cn/problems/range-sum-query-immutable/solutions/2693498/qian-zhui-he-ji-qi-kuo-zhan-fu-ti-dan-py-vaar/
 * 如果
 * sum[0] = 0
 * sum[1] = array[0]
 * sum[2] = array[0] + array[1]
 * sum[3] = array[0] + array[1] + array[2] ;
 * 数组array [1,2,3,4,5,6,7]
 * 下标 [0,1,2,3,4,5,6]
 * 4+5 = array[3]+array[4]=sum[5]-sum[3]
 * 任意的 i>j ; sum[i] - sum[j] = ( array[0] + array[1] +...+ array[j] +array[j+1] +...+array[i-1] ) - (array[0] + array[1] + array[j-1]
 * array[1] = sum[2] - sum[1];
 * array[0] = sum[1] - sum[0]; 也可以表示成 两个前缀和的差
 * array[k] = sum[k+1] - sum[k]
 * sum[k] = sum[k+1] - array[k]
 * 也就是 sum[k] k的数值 = 所对应求和数组的最后一位的下标+1：sum[3] = array[0] + array[1] + array[2] ; 3 = 2+1
 * 因此，任意区间的和，都可以用两个前缀和之差表示
 * <p>
 * 如果
 * sum[0] = array[0]
 * sum[1] = array[0] + array[1]
 * sum[2] = array[0] + array[1] + array[2]
 * sum[3] = array[0] + array[1] + array[2] + array[3]
 * <p>
 * array[1] = sum[1]-sum[0]
 * array[0] = sum[0] 无法表示成两个前缀和的差
 * 讲得很清楚了！解释了为什么前缀和数组要比原数组多一个
 */
public class NumArrayNew {

    private final int[] s;

    public NumArrayNew(int[] nums) {
        s = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            s[i + 1] = s[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return s[right + 1] - s[left];
    }

}
