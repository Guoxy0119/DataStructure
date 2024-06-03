package com.atguigu.linkedList;

/**
 * 约瑟夫问题
 * 1. 约瑟夫问题为：设编号为1，2，...n的n个人围坐一圈，约定编号为k(1<=k<=n)的人从1开始报数，
 * 数到m的那个人出列，它的下一位又从1开始报数，数到m的那个人又出列，依次类推，直到所有人出列为止，由此产生一个出队编号的序列
 * <p>
 * 根据用户的输入，生成一个小鬼出圈的顺序（方法：countBoy）
 * n = 5 , 即有5只鬼
 * k = 1, 从第一个小鬼开始报数
 * m = 2, 数2下(包括它自己也得数)
 * <p>
 * 出圈的顺序 : 2->4->1->5->3
 */
public class Josepfu {

    public static void main(String[] args) {
        //测试环形链表
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);// 加入5个小孩节点
        circleSingleLinkedList.showBoy();

        //测试小孩出圈
        circleSingleLinkedList.countBoy(1, 2, 5);

    }


}


// 创建一个环形的单向链表
class CircleSingleLinkedList {
    // 创建一个first节点，当前没有编号
    private Boy first = new Boy(-1);

    // 添加小孩节点，构建成一个环形的链表
    public void addBoy(int nums) {
        // nums 做一个数据校验
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }

        Boy curBoy = null; // 辅助指针，帮助构建环形链表
        // 使用for循环创建环形链表
        for (int i = 1; i <= nums; i++) {
            // 根据编号，创建小孩
            Boy boy = new Boy(i);
            //如果是第一个小孩，自己成环
            if (i == 1) {
                first = boy;
                first.setNext(first);//构成环
                curBoy = first;//让curBoy指向第一个小孩
            } else {

                curBoy.setNext(boy);//当前boy的下一个是新的boy
                boy.setNext(first);//新的boy的下一个是first
                curBoy = boy;//移动指针到新boy
            }
        }
    }

    //遍历当前环形链表
    public void showBoy() {
        //判断链表是否为空
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        //因为first不能动，因此我们仍然使用一个辅助指针
        Boy curBoy = first;
        while (true) {
            System.out.println("小孩的编号" + curBoy.getNo());
            if (curBoy.getNext() == first) { //说明已经遍历完毕
                break;
            }

            curBoy = curBoy.getNext();//curBoy后移

        }

    }

    /**
     * 根据用户的输入，计算出小孩出圈的顺序
     *
     * @param startNo  表示从第几个小孩开始数
     * @param countNum 表示数几下
     * @param nums     表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        //先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误，请重新输入");
            return;
        }

        //创建一个辅助指针，帮助完成小孩出圈
        Boy helper = first;
        //1. 需要创建一个辅助指针helper，事先应该指向环形链表的最后这个节点
        while (true) {
            if (helper.getNext() == first) {//说明helper指向了最后一个小孩节点
                break;
            }
            helper = helper.getNext();
        }

        //2. 小孩报数前，先让first和helper移动k-1次
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        //3. 当小孩报数时，让first和helper指针同时移动m-1次，然后出圈
        //这里是一个循环操作，直到圈中只有一个节点
        while (true) {
            if (helper == first) {//说明圈中只有一个节点
                break;
            }

            //让first和helper指针同时移动countNum-1
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }

            //这时first指向的节点，就是要出圈的小孩节点
            System.out.println("小孩" + first.getNo() + "出圈");
            //这时将first指向的小孩节点出圈
            first = first.getNext();
            helper.setNext(first);//helper的下一个节点指向first
        }

        System.out.printf("最后留在圈中的小孩编号 %d \n", first.getNo());

    }

}


//创建一个Boy类，表示一个节点
class Boy {
    private int no;//编号
    private Boy next;//指向下一个节点，默认null

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}