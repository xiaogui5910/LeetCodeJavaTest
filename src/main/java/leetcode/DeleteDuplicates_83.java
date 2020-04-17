package leetcode;

/**
 * 83. 删除排序链表中的重复元素
 * <p>
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class DeleteDuplicates_83 {
    public ListNode solution(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode result = head;
        while (head.next != null) {
            ListNode next = head.next;
            if (next.val == head.val) {
                head.next = next.next;
            } else {
                head = next;
            }
        }
        return result;
    }

    public void test() {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(3);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        ListNode temp = head;
        System.out.println("head=");
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        ListNode result = solution(head);
        temp = result;
        System.out.println();
        System.out.println("result=");
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
