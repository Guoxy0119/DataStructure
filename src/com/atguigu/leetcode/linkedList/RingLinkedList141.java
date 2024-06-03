package com.atguigu.leetcode.linkedList;

import java.util.HashSet;

/**
 * 环形链表
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 */
public class RingLinkedList141 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l2.next = l1;
        l1.next = l2;


        boolean result = hasCycle(l1);

        System.out.println(result);


    }

    /**
     * 快慢指针（龟兔赛跑算法）
     * 慢指针每次只移动一步，而快指针每次移动两步。初始时，慢指针在位置 head，而快指针在位置 head.next
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode fast = head.next;
        ListNode slow = head;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }

            fast = fast.next.next;
            slow = slow.next;
        }

        return true;

    }


    /**
     * 哈希表
     */
    public static boolean hasCycle1(ListNode head) {
        if (head == null) return false;

        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.add(head)) {
                head = head.next;

            } else {
                return true;
            }
        }
        return false;
    }


}
