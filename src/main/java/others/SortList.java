package others;

import dataStructure.MyNode;
import org.junit.Test;

/**
 *  5 2 3 8 7
 *  2 5 3 8 7
 *  2 3 5 8 7
 *  2 3 5 7 8
 */
public class SortList {
    public MyNode mergeSort(MyNode<Integer> head) {
        if (head == null || head.next == null)
            return head;
        MyNode p1 = head;
        MyNode p2 = head;
        // 1 2 3 4
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        // 1 2 3 4
        //  p1 p2

        p2 = p1.next;
        p1.next = null;
        head = mergeSort(head);
        p2 = mergeSort(p2);
        return merge(head, p2);
    }

    /**
     *   h1        h2
     *  {1, 4, 5} {2, 6, 7}
     *  1, 2, 4, 5 {6, 7}
     *
     *
     */
    public MyNode merge(MyNode<Integer> p1, MyNode<Integer> p2) {
        MyNode head = null;
        MyNode p = null;

        while (p1 != null && p2 != null) {
            if (p1.data < p2.data) {
                if (head == null) {
                    head = p1;
                    p = head;
                } else {
                    p.next = p1;
                    p = p.next;
                }
                p1 = p1.next;
            } else {
                if (head == null) {
                    head = p2;
                    p = head;
                } else {
                    p.next = p2;
                    p = p.next;
                }
                p2 = p2.next;
            }

        }

        if (p1 != null) {
            p.next = p1;
        }

        if (p2 != null) {
            p.next = p2;
        }

        return head;
    }

    @Test
    public void t1() {
        MyNode<Integer> n = new MyNode(5);
        MyNode<Integer> n1 = new MyNode(2);
        MyNode<Integer> n2 = new MyNode(3);
        MyNode<Integer> n3 = new MyNode(8);
        MyNode<Integer> n4 = new MyNode(7);

        n.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        MyNode result = mergeSort(n);
        while (result != null) {
            System.out.print(result.data + ",");
            result = result.next;
        }
    }

    @Test
    public void t2() {
        MyNode<Integer> n = new MyNode(2);
        MyNode<Integer> n1 = new MyNode(5);
        MyNode<Integer> n2 = new MyNode(3);

        n.next = n1;

        // n2.next = n3;
        //n3.next = n4;

        MyNode result = merge(n, n2);
        while (result != null) {
            System.out.print(result.data + ",");
            result = result.next;
        }
    }
}
