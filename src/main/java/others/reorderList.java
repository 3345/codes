package others;

import dataStructure.MyNode;
import org.junit.Test;

/**
 * {1,2,3,4,5} -> {1,5,2,4,3}
 * {1,2,3,4} -> {1,4,2,3}
 */

public class reorderList {

    public MyNode reorder(MyNode head) {
        MyNode mid = head, p2 = head;
        while (p2.next != null && p2.next.next != null) {
            mid = mid.next;
            p2 = p2.next.next;
        }
        MyNode newMid = reverse(mid.next);
        mid.next = null;
        MyNode cur = head;
        //{1,2,3} {5,4}
        while (cur != null && newMid != null) {
            MyNode nextCur = cur.next;
            MyNode nextNewMid = newMid.next;
            cur.next = newMid;
            newMid.next = nextCur;
            cur = nextCur;
            newMid = nextNewMid;
        }
        return head;
    }
    // 1->2->3->4->null
    // 1 2 3 4 5
    public MyNode reverse(MyNode head) {
        MyNode cur = head;
        MyNode newHead = null;
        while (cur != null) {
            MyNode temp = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = temp;
        }
        return newHead;
    }

    @Test
    public void t1() {
        MyNode n1 = new MyNode(1);
        n1.next = new MyNode(2);
        n1.next.next = new MyNode(3);
        n1.next.next.next = new MyNode(4);
       // n1.next.next.next.next = new MyNode(5);

        MyNode n = reorder(n1);
        System.out.println();
    }
}
