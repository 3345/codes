package leetcode;

/**
 Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:
 Given n will always be valid.
 Try to do this in one pass.
 */
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode last = head;
        for (int i = 0; i < n; i ++) {
            last = last.next;
        }
        while (last != null) {
            first = first.next;
            last = last.next;
        }
        if (first.next == head)
            return first.next.next;
        first.next = first.next.next;
        return head;
    }
}
