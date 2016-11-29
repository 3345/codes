package leetcode;

import java.util.List;

/**
 * Created by fyl on 11/28/16.
 */
public class PalindromeLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        if (head.next == null) {
            return true;
        }

        if (head.next.next == null) {
            return head.val == head.next.val;
        }

        ListNode slow = head;
        ListNode fast = head;
        int len = 0;
        boolean isOdd = true;

        while (slow != null && fast != null) {
            if (fast.next == null) {
                isOdd = true;
                break;
            }

            if( fast.next.next == null) {
                isOdd = false;
                break;
            }

            len ++;
            slow = slow.next;
            fast = fast.next.next;

        }

        ListNode p2 = slow.next;
        ListNode halfHead;

        if (isOdd) {
            len --;
            halfHead = slow;
        } else {
            halfHead = p2;
        }

        ListNode newHead = reverse(head, len);
        ListNode p1 = newHead;

        boolean ans = true;

        //restore list
        for (int i = 0; i < len + 1; i++) {
            if (p1.val != p2.val) {
                ans = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        ListNode n = reverse(newHead, len);

        ListNode tail = n;
        for (int i = 0; i < len; i++) {
            tail = tail.next;
        }

        tail.next = halfHead;

        return ans;
    }

    //if size is 2, len is 1
    private ListNode reverse(ListNode head, int len) {
        ListNode h1 = head;
        ListNode h2 = h1.next;
        h1.next = null;

        for (int i = 0; i < len; i++) {
            ListNode tmp = h2.next;
            h2.next = h1;
            h1 = h2;
            h2 = tmp;
        }

        return h1;

    }
}
