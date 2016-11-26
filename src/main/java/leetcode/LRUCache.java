package leetcode;

import java.util.HashMap;

public class LRUCache {
    private int capacity;
    private Node head;
    private Node tail;
    private HashMap<Integer, Node> map = new HashMap();
    private int vol;

    public LRUCache(int capacity) {
        this.capacity = capacity;

    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return  -1;
        }

        Node n = map.get(key);

        Node prev = n.prev;
        Node next = n.next;

        if (this.head != n) {
            if (this.tail == n) {
                prev.next = null;
                this.tail = prev;
            } else {
                prev.next = next;
                next.prev = prev;
            }

            addToHead(n);
        }

        return head.val;
    }

    public void set(int key, int value) {
        if (capacity < 1) {
            return;
        }

        if (this.map.containsKey(key)) {
            Node n = this.map.get(key);
            n.val = value;

            Node prev = n.prev;
            Node next = n.next;

            if (this.head != n) {

                if (this.tail == n) {
                    prev.next = null;
                    this.tail = prev;
                } else {
                    prev.next = next;
                    next.prev = prev;


                }
                addToHead(n);
                map.put(key, head);

            }
        } else {
            Node n = new Node(key, value);

            if (this.vol < this.capacity) {
                this.map.put(key, n);
                this.vol ++;
                addToHead(n);
            } else if (this.vol == this.capacity){
                if (tail == head) {
                }

                Node oldTail = this.tail;
                this.tail = oldTail.prev;
                if (this.tail != null) {
                    this.tail.next = null;
                }
                this.map.remove(oldTail.key);

                addToHead(n);
            } else {
                //cannot happen
            }

            map.put(key, head);
        }
    }

    private void addToHead(Node n) {
        Node oldHead = head;
        if (oldHead == null) {
            head = n;
            tail = n;
        } else {
            head = n;
            oldHead.prev = head;
            head.prev = null;
            head.next = oldHead;
        }

    }

    public class Node {
        public int val;
        public int key;
        public Node next;
        public Node prev;

        public Node(int key, int val) {
            this.val = val;
            this.key=key;
        }
    }

}
