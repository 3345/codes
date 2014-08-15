package others;

/**
 You are given two linked lists representing two non-negative numbers.
 The digits are stored in reverse order and each of their nodes contain a single digit.
 Add the two numbers and return it as a linked list.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode head = null;
        ListNode cur3 = null;
        int carry = 0;
        while (cur1 != null && cur2 != null) {
            int val = cur1.val + cur2.val + carry;
            int digit = val % 10;
            carry = val/10;
            if (head == null) {
                head = new ListNode(digit);
                cur3 = head;
            } else {
                cur3.next = new ListNode(digit);
                cur3 = cur3.next;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        while (cur1 != null) {
            int val = carry + cur1.val;
            int digit = val % 10;
            carry = val / 10;
            cur3.next = new ListNode(digit);
            cur1 = cur1.next;
            cur3 = cur3.next;
        }

        while (cur2 != null) {
            int val = carry + cur2.val;
            int digit = val % 10;
            carry = val / 10;
            cur3.next = new ListNode(digit);
            cur2 = cur2.next;
            cur3 = cur3.next;
        }

        if (carry > 0) {
            cur3.next = new ListNode(carry);
        }
        return head;
    }
}

