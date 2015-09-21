package leetcode;

import org.junit.Test;

/**
 Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode cur = head.next;
        ListNode start = head;
        ListNode end = head;
        int val = head.val;

        while (cur != null) {
            if (cur.val != val) {
                start.next = cur;
                start = cur;
                val = cur.val;
            }
            end = cur;
            cur = cur.next;
        }
        start.next = end.next;
        return head;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
          }
      }

    @Test
    public void test() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        n1.next = n2;
        deleteDuplicates(n1);
        System.out.println();
    }

}
