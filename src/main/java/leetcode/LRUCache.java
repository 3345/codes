package leetcode;

import org.junit.Test;

import java.util.HashMap;

public class LRUCache {
    private int cap;
    private HashMap<Integer, Node> map;
    private DoublyLinkedList dList;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
        this.dList = new DoublyLinkedList();
    }

    public int get(int key) {
        if (!this.map.containsKey(key)) {
            return -1;
        }

        Node node = this.map.get(key);
        this.dList.remove(node);
        this.dList.insertAfter(dList.head, node);
        return node.val;
    }

    public void put(int key, int value) {
        if (this.cap < 1) {
            return;
        }
        Node n = new Node(key, value);
        if (!this.map.containsKey(key)) {
            this.dList.insertAfter(dList.head, n);
            this.map.put(key,n);
            if (map.size() > this.cap) {
                this.map.remove(this.dList.tail.prev.key);
                this.dList.remove(this.dList.tail.prev);
            }
        } else {
            this.dList.remove(map.get(key));
            this.dList.insertAfter(dList.head, n);
            this.map.put(key, n);
        }
    }

    class Node {
        int val;
        int key;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }

    class DoublyLinkedList {
        Node head;
        Node tail;
        public DoublyLinkedList() {
            this.head = new Node(0,0);
            this.tail = new Node(0,0);
            this.head.next = this.tail;
            this.tail.prev = this.head;
        }

        public void insertAfter(Node a, Node in) {
            if (a == null) {
                return;
            }
            Node b = a.next;
            a.next = in;
            in.prev = a;
            in.next = b;
            b.prev = in;

        }

        public void remove(Node n) {
            if (n == null) {
                return;
            }
            n.prev.next = n.next;
            n.next.prev = n.prev;
        }
    }
}




