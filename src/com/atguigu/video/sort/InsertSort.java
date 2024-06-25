package com.atguigu.video.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {

//        int[] arr = {101, 34, 119, 1, -1, 89};

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

        insertSort(arr);

        System.out.println("排序后");
        Date date2 = new Date();
        String date2Str = sdf.format(date2);
        System.out.println("排序前的时间是=" + date2Str);


    }


    public static void insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i]; //定义待插入的数
            int insertIndex = i - 1; // 即arr[1]的前面的这个数的下标，待插入数要与前边那个数比较

            /*
             * 给inserVal找到插入的位置
             * 1. insertIndex >= 0 保证在给insertVal找插入位置时，不越界
             * 2. insertVal < arr[insertIndex] 说明待插入数还没有找到插入的位置
             * 3. 将arr[insertIndex] 后移
             */
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {

                arr[insertIndex + 1] = arr[insertIndex];//后移   {101, 34, 119, 1} => {101, 101, 119, 1}
                insertIndex--; // 没有这个代码会死循环，因为insertIndex没有变化，一直是大于等于0的，也没有把定义的有序数组的每个数比较。
            }
            //当退出while循环时，说明要插入的位置已经找到，insertIndex+1，因为上面的insertIndex--了
            if (insertIndex + 1 != i) { //优化，如果不需要移动，移动后还是在他本来的位置，就不用赋值了
                arr[insertIndex + 1] = insertVal;
            }

//            System.out.println("第" + i + "轮插入");
//            System.out.println(Arrays.toString(arr));
        }


    }


}
