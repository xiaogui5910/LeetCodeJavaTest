package leetcode;

import sort.Utils;

import javax.rmi.CORBA.Util;
import java.util.ArrayList;
import java.util.List;

/**
 * 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 */
public class RemoveNthFromEnd_19 {
    public ListNode solution(ListNode head, int n) {
        ListNode temp = head;
        int len = 0;
        List<ListNode> list = new ArrayList<ListNode>();
        while (temp != null) {
            len++;
            list.add(temp);
            temp = temp.next;
        }
        int index = len - n;
        if (index < 0) {
            return null;
        }
        if (index == 0) {
            return head.next;
        }
        ListNode listNode = list.get(index - 1);
        listNode.next = listNode.next == null ? null : listNode.next.next;
        return head;
    }

    public ListNode solution1(ListNode head, int n) {
        ListNode temp = new ListNode(0);
        temp.next = head;

        ListNode first = temp;
        ListNode second = temp;

        //为了找到删除结点前一个结点，所以n+1
        for (int i = 0; i < n + 1; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        //将删除结点前一结点的下一个结点设置为删除结点后一结点
        second.next = second.next.next;

        return temp.next;
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
        int n = 2;
        ListNode result = solution1(l1, n);
        Utils.printNum(this, result);
    }
}
