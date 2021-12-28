package quicktest;

import leetcode.ListNode;
import sort.Utils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaogui on 2021/12/28.
 */
public class HasCycleTest {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle1(ListNode head) {
        //双指针
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        //没追上
        while (slow != fast) {
            //判断快的有没有走完了，走完了还是没有追上，表示无循环
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


}
