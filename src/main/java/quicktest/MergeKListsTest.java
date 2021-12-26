package quicktest;

import leetcode.ListNode;

/**
 * Created by xiaogui on 2021/12/26.
 */
public class MergeKListsTest {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }

//    public ListNode mergeKLists(ListNode[] lists) {
//        ListNode ans = new ListNode(0);
//        ListNode cur = ans;
//        ListNode head = ans.next;
//        for (int i = 0; i < lists.length; i++) {
//            ListNode node = lists[i];
//            while (head != null && node != null) {
//                if (head.val <= node.val) {
//                    cur.next = head;
//                    head = head.next;
//                } else {
//                    cur.next = node;
//                    node = node.next;
//                }
//                cur = cur.next;
//            }
//            cur.next = head == null ? node : head;
//            head = ans.next;
//            cur = ans;
//        }
//
//        return ans.next;
//
//    }

    public void test() {
        ListNode l1 = new ListNode(1);
        ListNode l1_1 = new ListNode(4);
        ListNode l1_2 = new ListNode(5);
        l1.next = l1_1;
        l1_1.next = l1_2;

        ListNode l2 = new ListNode(1);
        ListNode l2_1 = new ListNode(3);
        ListNode l2_2 = new ListNode(4);

        l2.next = l2_1;
        l2_1.next = l2_2;

        ListNode l3 = new ListNode(2);
        ListNode l3_1 = new ListNode(6);

        l3.next = l3_1;

        ListNode[] lists = {l1,l2,l3};


        ListNode result = mergeKLists(lists);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
