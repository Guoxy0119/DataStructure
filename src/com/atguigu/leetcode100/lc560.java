package com.atguigu.leetcode100;

import java.util.HashMap;

public class lc560 {


    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 2, 1};
        int k = 3;
//        int[] nums = {-1, -1, 1};
//        int k = 0;
        int i = subarraySum(nums, k);
        System.out.println(i);

    }

    /**
     * https://leetcode.cn/problems/subarray-sum-equals-k/solutions/2883683/javapython3cqian-zhui-he-ha-xi-biao-lian-r2hn/?envType=study-plan-v2&envId=top-100-liked
     * 前缀和 + 哈希
     */
    public static int subarraySum(int[] nums, int k) {

        // pre[j] - pre[i] = k -->  pre[j] - k = pre[i] 即map的key值

        // 用来存放前缀和，key为前缀和的值，value为这个值出现的次数
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);// 初始化一个前缀为0的值，即当某个元素本身就为k时，不需要减去任何一个前缀，本身就是1次

        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i]; // 更新前缀和 [0,i+1)
            result = result + map.getOrDefault(preSum - k, 0);// result = result + （包含当前值的前缀和 - k = 所需要的前缀的值即[0,i)）
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }

        return result;

    }


    // 慢！
    public static int subarraySum1(int[] nums, int k) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i; j < nums.length; j++) {
                temp = temp + nums[j];
                if (temp == k) {
                    result++;
                }
            }
        }
        return result;

    }
}
