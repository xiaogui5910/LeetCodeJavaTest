package leetcode;

import sort.Utils;

/**
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class SwapPairs_24 {
    public ListNode solution(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;

        ListNode cur = temp;
        while (cur.next != null && cur.next.next != null) {
            ListNode next = cur.next.next;
            cur.next.next = next.next;
            next.next = cur.next;
            cur.next = next;

            cur = cur.next.next;
        }
        return temp.next;
    }

    public ListNode solution1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = solution1(next.next);
        next.next = head;
        return next;
    }

    public void test() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        Utils.printNum(this, l1);
        ListNode result = solution1(l1);
        Utils.printNum(this, result);
    }
}
