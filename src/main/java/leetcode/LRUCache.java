package leetcode;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
    private int capacity;
    private LinkedList<Node> doublyLinkedList;
    private HashMap<Integer, Node> map = new HashMap();
    private int vol;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        doublyLinkedList = new LinkedList<Node>();
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null)
            return -1;
        int val = node.val;
        doublyLinkedList.remove(node);
        doublyLinkedList.addLast(node);
        return val;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            doublyLinkedList.remove(map.get(key));
            vol --;
        }

        Node node = new Node(value);
        doublyLinkedList.addLast(node);
        map.put(key, node);
        vol ++;

        if (vol > capacity) {
            Node head = doublyLinkedList.removeFirst();
            Integer keyToRemove = null;
            for (int k : map.keySet()) {
                if (map.get(k).equals(head))
                    keyToRemove = k;
            }
            map.remove(keyToRemove);
            vol --;
        }

    }

    public class Node {
        public int val;
        public Node(int val) {
            this.val = val;
        }
    }

}
