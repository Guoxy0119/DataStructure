package com.atguigu.video.linkedList;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {

        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //直接加到后面
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);

        //按照编号顺序加入
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);

        //修改前
        singleLinkedList.list();

        //测试修改节点的代码
//        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~");
//        singleLinkedList.update(newHeroNode);
//        System.out.println("修改后链表----------");
//
        //删除一个节点
//        singleLinkedList.del(1);
//        singleLinkedList.del(3);
//        System.out.println("删除后链表----------");

        //求单链表中有效节点的个数
//        System.out.println(getLength(singleLinkedList.getHead()));


        //得到倒数第K个节点
//        HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 2);
//        System.out.println(res);

        //反转单链表
//        reverseList(singleLinkedList.getHead());
//        System.out.println("反转后");

        //逆序打印单链表
        reversePrint(singleLinkedList.getHead());
        System.out.println("逆序打印-----");


        //显示
        singleLinkedList.list();

    }

    /**
     * 逆序打印单链表
     * 方式1：先反转后遍历，但是这样会破坏原来的单链表结构，不推荐
     * 方式2：利用栈的先进后出的特点，将各个节点压入到栈中，实现逆序打印。链表本身没有发生变化
     * 方式3：新建集合
     */
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;
        }
        //创建一个栈，将各个节点压入栈中
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        //将链表的所有节点压入栈中
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;//cur后移，这样就可以压入下一个节点
        }
        //将栈中的节点进行打印，pop出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }

    }


    /**
     * 将单链表进行反转
     */
    public static void reverseList(HeroNode head) {
        //如果当前链表为空，或者只有一个节点，无需反转直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        //定义一个辅助变量,帮助我们遍历原来的链表
        HeroNode cur = head.next;
        //指向当前节点[cur]的下一个节点
        HeroNode curNext = null;
        //先定义一个头节点reverseHead
        HeroNode reverseHead = new HeroNode(0, "", "");

        //遍历原链表，每遍历一个节点，就将其  --取出--  ，并放在新的链表reverseHead的最前端
        while (cur != null) {
            curNext = cur.next;//先暂时保存当前节点的下一个节点

            cur.next = reverseHead.next;//将cur的下一个节点指向新链表的最前端
            reverseHead.next = cur;

            cur = curNext; //todo 让cur后移 这步没写出来
        }
        //将原链表头指向新生成的链表
        head.next = reverseHead.next;
    }

    /**
     * 查找单链表的倒数第K个节点
     * 思路：
     * 1. 编写一个方法接收head节点，同时接收一个index
     * 2. index表示的是倒数第index个节点
     * 3. 先把链表从头到尾遍历，得到链表的总长度size
     * 4. 得到size后，我们从链表的第一个开始遍历（size-index）个即可
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }

        //第一次遍历得到链表长度（节点个数）
        int size = getLength(head);
        //第二次遍历，遍历到size-index位置，就是我们倒数第k个节点
        //先做一个index的校验
        if (index <= 0 || index > size) {
            return null;
        }

        //定义一个辅助变量,for循环定位到倒数的index
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }


    /**
     * 求单链表中有效节点的个数(就是遍历一遍)
     * 方法：获取到单链表的节点的个数（如果是带头节点的链表，需求不统计头节点）
     *
     * @param head 链表的头节点
     * @return 返回的就是有效节点的个数
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            //空链表
            return 0;
        }
        int length = 0;
        //定义一个辅助变量，这里没有统计头节点
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }


}

//定义singleLinkedList 管理我们的英雄
class SingleLinkedList {

    //先初始化一个头节点，头节点不要动，不然找不到链表的起始位置，不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    //返回头节点
    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表:当不考虑编号顺序时，找到当前链表的最后节点，将最后节点的next指向新节点即可
    public void add(HeroNode heroNode) {
        //因为head节点不能动，因此我们需要一个辅助变量 temp
        HeroNode temp = head;
        //遍历链表，找到最后节点(即 next为空)
        while (true) {
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后，就将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后，将最后这个节点的next 指向新的节点
        temp.next = heroNode;
    }

    /**
     * 第二种方式在添加英雄时，根据排名将英雄插入到指定位置
     * 如果有这个排名，则添加失败，并给出提示。
     */
    public void addByOrder(HeroNode heroNode) {
        //因为头节点不能动，因此我们仍然通过一个辅助指针（变量）来帮助找到添加的位置
        //因为单链表，只有next节点没有prev节点，所以我们找的temp是位于添加位置的前一个节点，否则无法插入
        HeroNode temp = head;
        boolean flag = false;//标志添加的编号是否存在，默认为false
        while (true) {
            if (temp.next == null) {
                //说明temp已经在链表的最后
                break;
            }
            if (temp.next.no > heroNode.no) {
                //位置找到，就在temp的后面插入
                //如果直接写在if里，再没有数据的情况下调用此方法，会因为第一个判断temp.next.no==null成立，执行break;使得数据无法添加
                break;
            } else if (temp.next.no == heroNode.no) {
                //说明希望添加的heroNode的编号已经存在
                flag = true;
                break;
            }
            temp = temp.next;//后移
        }
        //判断flag的值
        if (flag) {
            System.out.printf("准备存入的英雄的编号%d 已经存在,不能加入\n", heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    /**
     * 修改节点的信息，根据no来修改即no不能修改
     * 1. 根据newHeroNode的no来修改即可
     */
    public void update(HeroNode newHeroNode) {
        //判空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head.next;
        boolean flag = false;//表示是否找到该节点
        while (true) {
            if (temp == null) {
                //表示链表已经遍历结束
                break;
            }
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else {
            System.out.printf("没有找到编号%d的节点，不能修改\n", newHeroNode.no);
        }
    }

    /**
     * 删除节点
     * 1. head不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
     * 2. 说明我们在比较时，是temp.next.no和需要删除的节点的no比较
     */
    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false;//标志是否找到待删除节点
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                //temp表示的是要删除节点的上一个节点
                flag = true;
                break;
            }
            temp = temp.next;
        }

        //判断flag
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的%d节点不存在", no);
        }
    }


    //显示链表[遍历]
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此 我们需要一个辅助变量来遍历
        // （因为头节点没数据，所以没必要遍历，直接取head.next）
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }

    }

}


//定义HeroNode，每个HeroNode对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;//指向下一个节点

    //构造器
    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
