package leetcode;

import sort.Utils;

/**
 * 2. 两数相加
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 */
public class AddTwoNumbers_2 {
    int carry = 0;

    public ListNode solution(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return carry != 0 ? new ListNode(carry) : null;
        }
        int v1 = l1 != null ? l1.val : 0;
        int v2 = l2 != null ? l2.val : 0;

        int temp = v1 + v2 + carry;
        if (temp > 9) {
            carry = temp / 10;
            temp %= 10;
        } else {
            carry = 0;
        }
        ListNode listNode = new ListNode(temp);

        ListNode subList = solution(l1 != null ? l1.next : null, l2 != null ? l2.next : null);
        listNode.next = subList;
        return listNode;
    }

    public void test() {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;
        Utils.printNum(this, l1);
        Utils.printNum(this, l4);
        ListNode result = solution(l1, l4);
        Utils.printNum(this, result);
    }

}
