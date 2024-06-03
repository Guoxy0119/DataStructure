package com.atguigu.linkedList;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        System.out.println("双向链表的测试");
        //先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        //创建链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
//        //直接加到后面
//        doubleLinkedList.add(hero1);
//        doubleLinkedList.add(hero2);
//        doubleLinkedList.add(hero3);
//        doubleLinkedList.add(hero4);

        //按序添加
        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero4);


        //修改前
        doubleLinkedList.list();

        //修改
//        HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "入云龙");
//        doubleLinkedList.update(newHeroNode);

        //删除
//        doubleLinkedList.del(1);


        //修改后
        System.out.println("修改后的链表");
        doubleLinkedList.list();

    }
}

/**
 * 创建一个双向链表的类
 */
class DoubleLinkedList {

    //先初始化一个头节点，头节点不要动，不然找不到链表的起始位置，不存放具体的数据
    private HeroNode2 head = new HeroNode2(0, "", "");

    //返回头节点
    public HeroNode2 getHead() {
        return head;
    }


    //添加节点到双向链表：默认添加到尾部
    public void add(HeroNode2 heroNode) {
        //因为head节点不能动，因此我们需要一个辅助变量 temp
        HeroNode2 temp = head;
        //遍历链表，找到最后节点(即 next为空)
        while (true) {
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后，就将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后,形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    /**
     * 第二种方式在添加英雄时，根据排名将英雄插入到指定位置
     * 如果有这个排名，则添加失败，并给出提示。
     */
    public void addByOrder(HeroNode2 heroNode) {
        // 因为头节点不能动，因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
        // 因为单链表，因为我们找的temp 是位于 添加位置的前一个节点，否则插入不了
        HeroNode2 temp = head;
        boolean flag = false;// flag标志添加的编号是否存在，默认为false
        while (true) {
            if (temp.next == null)
                break;
            if (temp.next.no > heroNode.no)
                // 位置找到，就在 temp后面
                // 因为 它满足了 按顺序 ，所以可以插入
                break;
            if (temp.next.no == heroNode.no) {
                // 已经存在改排行的编号(不可重复)
                flag = true;
                break;
            }
            // 没满足以上，后移下一次节点继续找
            temp = temp.next;
        }

        // 对 flag 进行判断
        if (flag)
            // 不能添加，说明编号已经存在
            System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.no);
        else {
            // 插入到链表中，temp的后面
            temp.next = heroNode;// 我后面是你
            temp = heroNode.pre;
        }
    }


    /**
     * 修改节点的信息，根据no来修改即no不能修改
     * 1. 根据newHeroNode的no来修改即可
     * 双向链表的节点内容修改和单向链表一样，
     */
    public void update(HeroNode2 newHeroNode) {
        //判空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode2 temp = head.next;
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
     * 1. 对于双向链表，我们可以直接找到要删除的这个节点
     * 2. 找到后自我删除即可
     */
    public void del(int no) {

        //判断当前链表是否为空
        if (head.next == null) {
            System.out.println("链表为空，无法删除");
        }

        HeroNode2 temp = head.next;//直接找待删除节点，而不是待删除节点的前一个节点
        boolean flag = false;//标志是否找到待删除节点
        while (true) {
            if (temp == null) {
                //已经找到链表的最后了
                break;
            }
            if (temp.no == no) {
                //temp表示的是要删除节点的上一个节点
                flag = true;
                break;
            }
            temp = temp.next;
        }

        //判断flag
        if (flag) {
            temp.next.pre = temp.pre;
            /**
             * 这里的代码有问题：如果删除的是最后这个节点，就会空指针异常
             * 所以删除的是最后一个节点，就不需要执行下面这句话
             */
            if (temp.next != null) {
                temp.pre.next = temp.next;
            }
        } else {
            System.out.printf("要删除的%d节点不存在", no);
        }
    }


    //遍历双向链表的方法，显示链表[遍历]
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此 我们需要一个辅助变量来遍历
        // （因为头节点没数据，所以没必要遍历，直接取head.next）
        HeroNode2 temp = head.next;
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
class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;//指向下一个节点,默认为null
    public HeroNode2 pre;//指向前一个节点,默认为null

    //构造器
    public HeroNode2(int no, String name, String nickName) {
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

