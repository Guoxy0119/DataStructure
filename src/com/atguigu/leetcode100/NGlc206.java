package com.atguigu.leetcode100;

public class NGlc206 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));

        ListNode listNode = reverseList(head);

        System.out.println(listNode.toString());
    }


    public static ListNode reverseList(ListNode head) {


        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode temp = cur.next;


            cur.next = pre;
            pre = cur;
            cur = temp;
        }


        return pre;

    }


}
