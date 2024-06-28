package com.atguigu.video.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = {-9, 78, 0, 23, -567, 70, -1, 900, 4561};


        // 创建80000个随机数的数组
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }

        System.out.println("排序前");
        Date date1 = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = sdf.format(date1);
        System.out.println("排序前的时间是=" + date1Str);

        quickSort1(arr, 0, arr.length - 1);

        System.out.println("排序后");
        Date date2 = new Date();
        String date2Str = sdf.format(date2);
        System.out.println("排序前的时间是=" + date2Str);


//        System.out.println("arr=" + Arrays.toString(arr));

    }


    /**
     * 快速排序
     *
     * @param arr   待排序数组
     * @param left  左下标
     * @param right 右下标
     */
    public static void quickSort1(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2]; // 中轴值
        int temp = 0; // 临时变量,作为交换时使用

        // while循环的目的是让比pivot值小放到左边,比pivot值大放到右边
        while (l < r) {
            // 在pivot的左边一直找,找到大于等于pivot值,才退出
            while (arr[l] < pivot) {
                l += 1;
            }

            // 在pivot的右边一直找,找到小于等于pivot值,才退出
            while (arr[r] > pivot) {
                r -= 1;
            }

            // 若 l >= r 则说明 pivot 两边的值已经按照 规则 ：
            // 左边全部小于等于pivot,右边全部大于等于pivot 排列好了(最终结果)
            if (l >= r) {
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现这个arr[l] == pivot ，前移 r--
            if (arr[l] == pivot) {
                r -= 1;
            }

            //如果交换完后，发现这个arr[r] == pivot ，前移 l++
            if (arr[r] == pivot) {
                l += 1;
            }
        }

        //如果l==r，必须l++  ,r--，不然if (l >= r)这个条件退不出来，否则会出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }


        //向左递归
        if (left < r) {
            quickSort1(arr, left, r);
        }

        //向右递归
        if (right > l) {
            quickSort1(arr, l, right);

        }


    }


    public static void quickSort2(int[] a, int l, int r) {

        if (l < r) {
            int i, j, x;

            i = l;
            j = r;
            x = a[i];
            while (i < j) {
                while (i < j && a[j] > x)
                    j--; // 从右向左找第一个小于x的数
                if (i < j)
                    a[i++] = a[j];
                while (i < j && a[i] < x)
                    i++; // 从左向右找第一个大于x的数
                if (i < j)
                    a[j--] = a[i];
            }
            a[i] = x;
            quickSort2(a, l, i - 1); /* 递归调用 */
            quickSort2(a, i + 1, r); /* 递归调用 */
        }
    }

    public static void quickSort3(int nums[], int start, int end) {
        //数组有多个元素进行排序
        if (start < end) {
            int base = nums[start];//以要进行排序数组第0个元素为base
            int left = start;//左指针
            int right = end;//右指针
            while (left < right) {
                //从右向左找，比base大，right--
                while (left < right && nums[right] >= base) {
                    right--;
                }
                //比base小，替换left所在位置的数字
                nums[left] = nums[right];
                //从左向右找，比base小，left++
                while (left < right && nums[left] <= base) {
                    left++;
                }
                //比base大，替换right所在位置的数字
                nums[right] = nums[left];
            }
            nums[left] = base;//此时left=right，用base替换这个位置的数字
            //排列比base小的数字的数组
            quickSort3(nums, start, left - 1);
            //排列比base大的数字的数组
            quickSort3(nums, left + 1, end);
        }
    }


}
