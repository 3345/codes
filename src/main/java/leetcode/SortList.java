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

        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        return mergeSort(head, tail);
    }

    public ListNode mergeSort(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }

        if (head == tail) {
            return head;
        }

        ListNode mid = findMid(head, tail);
        ListNode head2 = mid.next;
        mid.next = null;

        return merge(mergeSort(head, mid), mergeSort(head2, tail));
    }

    //merge two sorted list
    public ListNode merge(ListNode h1, ListNode h2) {
        //dummy head, real head is dummy head next
        ListNode h = new ListNode(0);
        ListNode cur = h;

        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                cur.next = h1;
                h1 = h1.next;
            } else {
                cur.next = h2;
                h2 = h2.next;
            }

            cur = cur.next;
        }

         if (h1 != null) {
             cur.next = h1;
         }

        if (h2 != null) {
            cur.next = h2;
        }

        return h.next;
    }

    public ListNode findMid(ListNode head, ListNode tail) {
        ListNode cur = head;
        int len = 0;

        while (cur != tail) {
            cur = cur.next;
            len++;
        }

        cur = head;

        for (int i = 0; i < len / 2; i++) {
            cur = cur.next;
        }

        return cur;
    }

    @Test
    public void test() {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(8);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode sorted = sortList(n1);
        System.out.println(sorted);

    }

}
