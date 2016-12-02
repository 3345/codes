package leetcode;

import java.util.LinkedList;

/**
 * Created by fyl on 12/1/16.
 */
public class MergekSortedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        LinkedList<ListNode> q = new LinkedList<>();

        for (int i = 0; i < lists.length; i++) {
            q.push(lists[i]);
        }

        while (!q.isEmpty()) {
            ListNode n1 = q.removeFirst();
            if (!q.isEmpty()) {
                ListNode n2 = q.removeFirst();
                q.addLast(mergeTwoLists(n1, n2));
            } else {
                return n1;
            }
        }

        return null;
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
