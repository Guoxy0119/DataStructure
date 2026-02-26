package test;

import java.util.Arrays;

public class Test {


    public static void main(String[] args) {

        int[] nums1 = {2, 0};
        int m = 1;
        int[] nums2 = {1};
        int n = 1;

        merge(nums1, m, nums2, n);
    }

    /**
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
     * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int a = m - 1;
        int b = n - 1;
        int p = m + n - 1;

        while (b >= 0) {
            if (a >= 0 && nums1[a] > nums2[b]) {
                nums1[p--] = nums1[a--];
            } else {
                nums1[p--] = nums2[b--];
            }
        }

        System.out.println(Arrays.toString(nums1));

    }


}
