package com.atguigu.leetcode.linkedList;

/**
 * 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * <p>
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 */
public class RemovesLinkedListElement203 {

    public static void main(String[] args) {
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(4, new ListNode(5, new ListNode(6))))));
        ListNode head = new ListNode(6, new ListNode(6, new ListNode(6)));

        ListNode listNode = removeElements1(head, 6);
        System.out.println(listNode.toString());
    }


    /**
     * 递归
     */
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        head.next = removeElements(head.next, val);

        if (head.val == val) {
            head = head.next;
        }

        return head;
    }


    /**
     * 删除头结点时另做考虑
     */
    public static ListNode removeElements1(ListNode head, int val) {
        //删除值相同的头结点后，可能新的头结点也值相等，用循环解决
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null)
            return head;
        ListNode prev = head;
        //确保当前结点后还有结点
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

}
