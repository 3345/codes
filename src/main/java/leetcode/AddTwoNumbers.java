package leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 You are given two linked lists representing two non-negative numbers.
 The digits are stored in reverse order and each of their nodes contain a single digit.
 Add the two numbers and return it as a linked list.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        int carry = 0;
        ListNode dum = new ListNode(0);
        ListNode cur = dum;
        ListNode t = dum;

        while (c1 != null && c2 != null) {
            int s = c1.val+c2.val+carry;
            carry = s/10;
            s=s%10;
            cur.next = new ListNode(s);
            cur = cur.next;
            t = cur;
            c1 = c1.next;
            c2 = c2.next;
        }

        if (c1!=null) {
            cur.next = c1;
            cur = cur.next;
        }
        if (c2!=null) {
            cur.next = c2;
            cur = cur.next;
        }
        while (cur!=null&&t!=cur) {
            int s = cur.val+carry;
            carry = s/10;
            cur.val = s%10;
            t = cur;
            cur = cur.next;
        }
        if (carry != 0) {
            t.next = new ListNode(1);
        }

        return dum.next;
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        addTwoNumbers(l1,l2);
    }
}

