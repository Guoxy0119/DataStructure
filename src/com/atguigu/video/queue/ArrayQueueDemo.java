package com.atguigu.video.queue;
import java.util.Scanner;

/**
 * 问题分析：
 * 1. 目前数组使用一次 就不能用，没有达到复用的效果
 * 2. 将这个数组使用算法，改进成一个环形的队列   取模：%
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {

        //创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
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
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
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

/**
 * 使用数组模拟队列-编写一个ArrayQueue类
 */
class ArrayQueue {

    private int maxSize;//表示数组的最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//该数组用于存放数据，模拟队列

    //创建队列的初始化构造器（此时没有数据存入）
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头 ,front的值是指向队列头的前一个位置
        rear = -1;//指向队列尾，队列最后一个数据的位置
    }

    //判断队列是否已经存满
    public boolean isFull() {
        return rear == maxSize - 1;
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
        rear++;
        arr[rear] = n;
    }

    //获取队列的数据，出队列
    public int getQueue() {
        //判断队列是否空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        }

        front++;
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue() {
        //遍历数据
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    //显示队列的头数据，注意不是取出数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front + 1];
    }


//    当尾巴-头 等于数组最大容量的时候就是满，因为当往外取数据的时候，
//    尾巴read 是不变的 ，假设read==maxsize-1 但是front是变的
//    这时候不满 也满足rear==maxSize-1;
}


