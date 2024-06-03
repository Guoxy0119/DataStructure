package com.atguigu.video.sparseArray;

import java.io.*;

/**
 * 将一个二维数组 转化为稀疏数组 存到磁盘中 再还原为二维数组
 */
public class SparseArray {

    public static void main(String[] args) {
        /**
         * 先创建一个原始的二维数组 11*11
         * 0：没有棋子，1 黑子 ，2 蓝子
         */
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;

        //输出原始的二维数组
        System.out.println("原始的二维数组");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        /**
         * 将二维数组转稀疏数组
         * 1.先遍历二维数组 得到非0数据个数
         *
         * 二维数组的长度：
         * 行：chessArr1.length；
         * 列：chessArr1[0].length；
         */
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }

        //2.创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        //3. 给稀疏数组赋值
        sparseArr[0][0] = chessArr1.length;
        sparseArr[0][1] = chessArr1[0].length;
        sparseArr[0][2] = sum;
        //遍历二维数组，将非0值存到稀疏数组中
        int count = 0;//用于记录是第几个非0数据,放到稀疏数组的第几行
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        //输出稀疏数组的形式
        System.out.println("得到的稀疏数组：");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
        System.out.println();


//=================================================================
        /**
         * 将稀疏数组转换为原二维数组
         * 1.先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组。
         * 2.在读取稀疏数组后几行的数据，并赋给原始的二维数组即可。
         */

        int chessArr[][] = new int[sparseArr[0][0]][sparseArr[0][1]];

        //组成原二位数组
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        //输出原二维数组
        System.out.println("还原后的原二维数组：");
        for (int[] row1 : chessArr) {
            for (int data : row1) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }


        //=================================================================
        //稀疏序列化
        sparseSerialize(sparseArr);

        //稀疏反序列化
        int[][] arr = (int[][])sparseDSerialize(resourcePath);
        System.out.println("最后得到类class类型"+arr.getClass().getName());

    }

    /**
     * 稀疏数组的序列化与反序列化
     */
    public final static String resourcePath = "E:\\Learn\\file";

    //序列化工具类
    private static void sparseSerialize(int[][] array){

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(resourcePath));
            oos.writeObject(array);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //反序列化工具类
    private static Object sparseDSerialize(String path){

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(resourcePath));
            Object arr = ois.readObject();
            return arr;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
