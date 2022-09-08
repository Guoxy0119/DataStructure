package com.atguigu.queue;

import java.util.Scanner;

/**
 * 环形数组队列
 * 约定front指向队列的第一个元素，也就是说data[front]就是队头数据，front初始值为0。
 * 约定rear指向队列的最后一个元素的后一个位置，也就是说data[rear-1]就是队尾数据，rear初始值为0。
 * 队列满的条件是：***( rear+1 )% maxSize == front***
 * 队列空的条件是：rear == front
 * 队列中的元素个数为：***( rear + maxsize - front) % maxSize***
 * 因为rear指向队尾的后面一个位置，这个位置就不能存数据，因此有效数据只有maxSize-1个
 * 留一个空间防止数组越界；不预留一个空间，rear == front也可能是队列满的情况
 */
public class circleArrayQueue {

    public static void main(String[] args) {

        System.out.println("测试数组模拟环形队列的案例");

        //创建一个环形队列；这里设置的队列长度为4，但其队列的有效数据最大是3
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(4);
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;//默认死循环
        //输出一个菜单
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头数据");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key){
                case 's':
                    circleArrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    circleArrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = circleArrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    try {
                        int res = circleArrayQueue.headQueue();
                        System.out.printf("队列头的数据是%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }


}


class CircleArrayQueue {

    private int maxSize;//表示数组的最大容量
    /**
     * 队列头,调整为指向第一个元素,也就是说arr[front]就是队列的第一个元素，front的初始值=0
     */
    private int front;
    /**
     * 队列尾，调整为指向队列的最后一个元素的后一个位置，因为希望空出一个空间作为约定，rear的初始值=0
     */
    private int rear;
    private int[] arr;//该数组用于存放数据，模拟队列

    //创建队列的初始化构造器（此时没有数据存入）
    public CircleArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    //判断队列是否已经存满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 添加数据队列
     *
     * @param n 要在数组里存放的数据
     */
    public void addQueue(int n) {
        //判断队列是否存满
        if (isFull()) {
            System.out.println("队列已满，不能加入数据");
            return;
        }
        arr[rear] = n;
        //将rear后移，这里必须考虑取模
        rear = (rear + 1) % maxSize;
    }

    //获取队列的数据，出队列
    public int getQueue() {
        //判断队列是否空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        }

        /**
         * 这里需要分析出front是指向队列的第一个元素
         * 1. 先把front对应的值保存到一个临时变量
         * 2. 将front后移,考虑取模
         * 3. 将临时保存的变量返回
         */
        int value  = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显示队列的所有数据
    public void showQueue() {
        //遍历数据
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        }
        /**
         * 思路：
         * 从front开始遍历，遍历多少个元素
         *
         */
        for (int i = front; i < front+size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //求出当前队列有效数据的个数
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列的头数据，注意不是取出数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front];
    }


//    当尾巴-头 等于数组最大容量的时候就是满，因为当往外取数据的时候，
//    尾巴read 是不变的 ，假设read==maxsize-1 但是front是变的
//    这时候不满 也满足rear==maxSize-1;
}