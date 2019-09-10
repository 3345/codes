package leetcode;

import org.junit.Test;

public class InsertintoACyclicSortedList {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node n = new Node(insertVal, null);
            n.next = n;
            return n;
        }
        Node prev = null;
        Node cur = head;

        while (head != cur || prev == null) {
            prev = cur;
            cur = cur.next;

            if (prev.val == insertVal || (prev.val < insertVal && cur.val > insertVal)) {
                Node n = new Node(insertVal, cur);
                prev.next = n;
                return head;
            }
            if (prev.val > cur.val) {
                if (insertVal < cur.val || insertVal > prev.val) {
                    Node n = new Node(insertVal, cur);
                    prev.next = n;
                    return head;
                }
            }
        }
        Node n = new Node(insertVal, head);
        prev.next = n;

        return head;
    }
    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val,Node _next) {
            val = _val;
            next = _next;
        }
    }

    @Test
    public void test() {
        Node n1 = new Node(1, null);
        Node n5 = new Node(5, n1);
        Node n3 = new Node(3, n5);
        n1.next = n3;
        insert(n1, 6);
    }
}
