package leetcode;

/**
 * Created by fyl on 11/27/16.
 */
public class LinkedListCycle {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;

        ListNode fast = head.next.next;


        while(fast != null && slow != null) {
            if (slow == fast) {
                return true;
            }

            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                return false;
            }
            fast = fast.next;
        }

        return false;

    }
}
