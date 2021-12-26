package other;

import leetcode.ListNode;

/**
 * 以 K 个结点为一组，将给定的单链表进行翻转。有点类似之前的链表两两翻转，只是那时的 K = 2。而在这道题中，K 变成一个外部传入的正整数，它是一个可变的值，并且小于或者等于链表的长度。
 */
public class ReverseKGroup {
    public ListNode solution(ListNode root, int k) {
        if (root == null) {
            return null;
        }

        int count = 1;
        ListNode temp = root;
        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }
        if (temp == null) {
            return root;
        }
        ListNode subList = temp.next;
        temp.next = null;

        ListNode reverseList = reverseList(root);
        ListNode newTemp = solution(subList, k);
        root.next = newTemp;
        return reverseList;

    }

    private ListNode reverseList(ListNode root) {
        if (root == null || root.next == null) {
            return root;
        }
        ListNode listNode = reverseList(root.next);
        root.next.next = root;
        root.next = null;
        return listNode;
    }

    public void test() {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(5);
        ListNode head5 = new ListNode(6);
        ListNode head6 = new ListNode(7);
        ListNode head7 = new ListNode(8);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = head6;
        head6.next = head7;

        ListNode temp = head;
        System.out.println(this.getClass().getSimpleName()+"-------------------");
        System.out.println("head=");
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        ListNode result = solution(head, 3);

        temp = result;
        System.out.println();
        System.out.println("result=");
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
        System.out.println(this.getClass().getSimpleName()+"-------------------");
    }

}
