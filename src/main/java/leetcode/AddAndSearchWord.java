package leetcode;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * Created by fyl on 11/20/16.
 */
public class AddAndSearchWord {
    Node root = new Node();

    // Adds a word into the data structure.
    public class Node {
        public Character c = null;
        public Map<Character, Node> children = new HashMap<>();
        public boolean t;

        public Node() {}

        public Node(Character c) {
            this.c = c;
        }

        public Node(Character c, boolean t) {
            this.c = c;
            this.t = t;
        }
    }

    public void addWord(String word) {
        char[] arr = word.toCharArray();

        Node cur = this.root;

        for (int i = 0; i < arr.length; i++) {
            Character c = arr[i];
            if (!cur.children.containsKey(c)) {
                Node n = new Node(c);
                if (i == arr.length - 1) {
                    n.t = true;
                }
                cur.children.put(c, n);
            } else {
                if ( i == arr.length - 1) {
                    cur.children.get(c).t = true;
                }
            }

            cur = cur.children.get(c);
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        char[] arr = word.toCharArray();

        return doSearch(arr, 0, this.root);
    }

    //search start from i, inclusive
    public boolean doSearch(char[] target, int i, Node root) {
        if (i > target.length - 1) {
            return false;
        }

        for (Map.Entry<Character, Node> entry : root.children.entrySet()) {
            if (entry.getValue().c == target[i] || target[i] == '.') {
                if (i == target.length - 1) {
                    return entry.getValue().t;
                } else if(doSearch(target, i + 1, entry.getValue())) {
                    return true;
                }
            }

        }

        return false;
    }

    @Test
    public void t0() {
        AddAndSearchWord obj = new AddAndSearchWord();
        obj.addWord("a");
        System.out.println(obj.search("."));
    }
}
