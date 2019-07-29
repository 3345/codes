package leetcode;

import org.junit.Test;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode s = new ListNode(0);
        ListNode b = new ListNode(0);

        ListNode ps = s;
        ListNode pb = b;

        while (head != null) {
            if (head.val < x) {
                ps.next = head;
                ps = ps.next;
            } else {
                pb.next = head;
                pb = pb.next;
            }
            head = head.next;
            ps.next = null;
            pb.next = null;
        }

        if (ps != null) {
            ps.next = b.next;
            return s.next;
        } else {
            return b.next;
        }
    }

    @Test
    public void test() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        ListNode n = partition(n1, 3);
        System.out.println(n);
    }
}
