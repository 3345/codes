package leetcode;

/**
 * Created by fyl on 11/28/16.
 */
public class IntersectionofTwoLinkedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode iter = headA;
        int lenA = 0;
        int lenB = 0;

        while (iter != null) {
            iter = iter.next;
            lenA ++;
        }

        iter = headB;

        while (iter != null) {
            iter = iter.next;
            lenB++;
        }

        int diff = lenA - lenB;

        ListNode iterA = headA;
        ListNode iterB = headB;

        if (diff > 0) {
            for (int i = 0; i < diff; i++) {
                iterA = iterA.next;
            }
        } else {
            for (int i = 0; i < diff * (-1); i++) {
                iterB = iterB.next;
            }
        }

        while (iterA != null && iterB != null) {
            if (iterA.val == iterB.val) {
                return iterA;
            }

            iterA = iterA.next;
            iterB = iterB.next;
        }

        return null;
    }
}
