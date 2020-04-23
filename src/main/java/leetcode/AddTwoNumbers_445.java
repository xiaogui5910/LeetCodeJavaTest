package leetcode;

import sort.Utils;

import java.util.Stack;

/**
 * 445. 两数相加 II
 *
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 *  
 *
 * 进阶：
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 *  
 *
 * 示例：
 *
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 *
 */
public class AddTwoNumbers_445 {

    public ListNode solution(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        ListNode tempListNode = null;

        int carry = 0;

        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            Integer a = s1.isEmpty() ? 0 : s1.pop();
            Integer b = s2.isEmpty() ? 0 : s2.pop();
            int temp = a + b + carry;
            if (temp > 9) {
                carry = temp / 10;
                temp %= 10;
            } else {
                carry = 0;
            }
            ListNode listNode = new ListNode(temp);
            listNode.next = tempListNode;
            tempListNode = listNode;
        }

        return tempListNode;
    }

    public void test() {
        ListNode l0 = new ListNode(7);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l0.next = l1;
        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;
        Utils.printNum(this, l1);
        Utils.printNum(this, l4);
        ListNode result = solution(l0, l4);
        Utils.printNum(this, result);
    }
}
