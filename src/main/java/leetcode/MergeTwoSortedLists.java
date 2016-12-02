package leetcode;

/**
 * Created by fyl on 12/1/16.
 */
public class MergeTwoSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dumHead = new ListNode(0);
        ListNode tail = dumHead;

        while(p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                tail.next = p1;
                tail = p1;
                p1 = p1.next;
                tail.next = null;
            } else {
                tail.next = p2;
                tail = p2;
                p2 = p2.next;
                tail.next = null;
            }
        }

        if (p1 != null) {
            tail.next = p1;
        }

        if (p2 != null) {
            tail.next = p2;
        }

        return dumHead.next;
    }
}
