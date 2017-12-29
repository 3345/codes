package leetcode;

/**
 * Created by fyl on 12/28/17.
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode p = head;
        ListNode c = head.next;

        while (c != null) {
            if (c.val == val) {
                p.next = c.next;
            }

            p = c;
            c = c.next;
        }

        return head;
    }
}
