package leetcode;

/**
 * Created by fyl on 11/27/16.
 */
public class ReverseLinkedList {

     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode h1 = head;
        ListNode h2 = head.next;
        h1.next = null;

        while (h2 != null) {
            ListNode nh2 = h2.next;
            h2.next = h1;
            h1 = h2;
            h2 = nh2;
        }

        return h1;

    }
}
