package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by fyl on 11/27/16.
 */
public class InsertDeleteGetRandomO1 {
    public class Node {
        int val;
        Node prev;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public class RandomizedSet {
        Node head;
        Node tail;

        Map<Integer, Node> map = new HashMap<>();


        /** Initialize your data structure here. */
        public RandomizedSet() {

        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }

            Node n = new Node(val);
            if (tail == null) {
                head = n;
            } else {
                tail.next = n;
                n.prev = tail;
            }

            tail = n;
            map.put(val, n);
            return true;

        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return  false;
            }

            Node n = map.get(val);

            if (head == tail) {
                head = null;
                tail = null;
            } else if (n == head) {
                head = n.next;
                head.prev = null;
            } else if (n == tail) {
                tail = n.prev;
                tail.next = null;
            } else {
                Node prev = n.prev;
                Node next = n.next;
                prev.next = next;
                next.prev = prev;
            }

            map.remove(val);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            if (head == null) {
                return 0;
            }

            int ret = head.val;

            if (head == tail) {
                return ret;
            }

            int t = new Random().nextInt(map.size());

            for (int i = 0; i < t; i++) {
                Node n = head;

                head = n.next;
                head.prev = null;

                tail.next = n;
                n.prev = tail;
                n.next = null;

                tail = n;
            }



            return head.val;
        }
    }
}
