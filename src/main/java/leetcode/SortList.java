package leetcode;

import org.junit.Test;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SortList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode head2 = partition(head);
        if (head2 == null) {
            return head;
        }

        ListNode sorted1 = sortList(head);
        ListNode sorted2 = sortList(head2);
        return merge(sorted1, sorted2);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dum = new ListNode(0);
        ListNode cur = dum;
        while(head1 != null && head2 != null) {
            if (head1.val > head2.val) {
                cur.next = head2;
                head2 = head2.next;
            } else {
                cur.next = head1;
                head1 = head1.next;
            }
            cur = cur.next;
        }
        if (head1 != null) {
            cur.next = head1;
        }
        if (head2 != null) {
            cur.next = head2;
        }
        return dum.next;
    }

    //return last element of first segment
    private ListNode partition(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;
        return head2;
    }

    @Test
    public void test() {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode sorted = sortList(n1);
        System.out.println(sorted);

    }

}
