package com.atguigu.leetcode100;

public class NGlc160 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(8, new ListNode(4, new ListNode(5)));

        ListNode headA = new ListNode(4, new ListNode(1, listNode));
        ListNode headB = new ListNode(5, new ListNode(6, new ListNode(1, listNode)));

        ListNode node = getIntersectionNode(headA, headB);
        System.out.println(node);
    }


    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a != null ? a.next : headB;
            b = b != null ? b.next : headA;
        }
        return a;

    }
}


