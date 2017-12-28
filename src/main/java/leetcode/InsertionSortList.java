package leetcode;

/**
 * Created by fyl on 12/27/17.
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode insertee = head.next;

        if (insertee == null) {
            return head;
        }

        ListNode inserteePrev = head;
        ListNode inserteeNext = insertee.next;
        ListNode newHead = head;

        while (insertee != null) {
            ListNode cur = newHead;
            ListNode prev = null;
            boolean moved = false;

            while(cur != insertee) {
                if (insertee.val < cur.val) {
                    if (prev != null) {
                        prev.next = insertee;
                    } else {
                        newHead = insertee;
                    }
                    insertee.next = cur;
                    inserteePrev.next = inserteeNext;
                    moved = true;
                    break;
                } else {
                    prev = cur;
                    cur = cur.next;
                }
            }

            if(!moved) {
                inserteePrev = inserteePrev.next;
            }
            insertee = inserteeNext;
            if (insertee == null) {
                break;
            }
            inserteeNext = insertee.next;
        }

        return newHead;
    }
}
