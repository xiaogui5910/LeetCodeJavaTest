package other;

import leetcode.ListNode;

/**
 * 给定单链表的头结点 head，实现一个调整链表的函数，从链表尾部开始，以 K 个结点为一组进行逆序翻转，头部剩余结点不足一组时，不需要翻转。（不能使用队列或者栈作为辅助）
 * <p>
 * 解决方案:
 * 将链表先翻转后处理，再翻转回去，这样并不优雅，其实只需一次以 K 个一组翻转链表就可以。
 * <p>
 * 再回忆一下k个一组翻转链表题，它和这道题的差异，主要来自于，对不足一组的链表结点的处理。前者是从头结点开始处理，所以多出来的结点会在尾部，而现在这道题则正好相反，余下的结点会在头部。
 * <p>
 * 但是它们同时也有一种特殊情况，就是 K 个一组进行分组时，这里的 K 正好可以完整的分组，一个不多，一个不少的分成 N 组。
 * <p>
 * 当链表结点数量正好为 K * N 时，那么就又回到了我们熟悉的 k个一组翻转链表题了。
 * <p>
 * 如果我们先将原始结点进行处理，找出它正好可以整除 K 的起始结点 offset，将这个起始结点 offset 的子链表，进行 K 个一组进行翻转链表，最后把它拼接回原始链表，就完成了这道题。
 * <p>
 * 这个过程，需要额外定义两个结点，第一个满足 K 个分组条件的 offset 结点，以及 offset 的前驱结点 prev 结点，prev 结点主要是用来拼接翻转后的两个链表，让其不会出现链表断裂的问题。
 */
public class ReverseKGroupPlus {
    public ListNode solution(ListNode head, int k) {
        if (head == null || k < 1) {
            return head;
        }
        int len = getListNodeLength(head);
        int delta = len % k;
        //整好是满足k组翻转链表
        if (delta == 0) {
            return new ReverseKGroup().solution(head, k);
        }
        ListNode temp = head;
        ListNode prev = head;
        while (delta > 0) {
            //更新下一个之前，先保存上一个
            prev = temp;
            //更新下一个结点
            temp = temp.next;
            delta--;
        }
        prev.next = new ReverseKGroup().solution(temp, k);
        return head;

    }

    private int getListNodeLength(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
    public void test(){
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
