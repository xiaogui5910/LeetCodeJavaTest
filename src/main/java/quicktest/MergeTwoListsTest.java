package quicktest;

import leetcode.ListNode;
import sort.Utils;

import java.util.List;

/**
 * Created by xiaogui on 2021/12/25.
 */
public class MergeTwoListsTest {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head=new ListNode(0);
        ListNode cur= head;
        while (list1!=null&&list2!=null){
            if (list1.val<=list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else{
                cur.next = list2;
                list2 =list2.next;
            }
            cur = cur.next;

        }
        cur.next = list1==null?list2:list1;
        return head.next;
    }

    public void test() {
        ListNode l1 = new ListNode(1);
        ListNode l1_1 = new ListNode(2);
        ListNode l1_2 = new ListNode(4);
        l1.next = l1_1;
        l1_1.next = l1_2;

        ListNode l2 = new ListNode(1);
        ListNode l2_1 = new ListNode(3);
        ListNode l2_2 = new ListNode(4);

        l2.next = l2_1;
        l2_1.next = l2_2;

        ListNode result = mergeTwoLists(l1, l2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
