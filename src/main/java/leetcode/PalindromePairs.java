package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePairs {

    public List<List<Integer>> palindromePairs(String[] words) {
        Node root = new Node();
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            addWord(words[i], root, i);
        }

        for (int i = 0; i < words.length; i++) {
            search(words[i], root, i, res);
        }
        return res;
    }

    private void addWord(String word, Node root, int index) {
        Node cur = root;
        for (int i = word.length() - 1; i > -1; i--) {
            char c = word.charAt(i);
            if (cur.next[c - 'a'] == null) {
                cur.next[c - 'a'] = new Node();
            }
            if (isPal(word, 0, i)) {
                cur.list.add(index);
            }
            cur = cur.next[c - 'a'];
        }
        cur.list.add(index);
        cur.index = index;
    }

    private void search(String word, Node root, int idx, List<List<Integer>> res) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next[c - 'a'] == null) {
                return;
            }

            if (cur.next[c - 'a'].index != -1 && cur.next[c - 'a'].index != idx && (isPal(word, i, word.length()-1))) {
                res.add(Arrays.asList(idx, cur.next[c - 'a'].index));
            }
            cur = cur.next[c - 'a'];
        }
        for (int i : cur.list) {
            if (i != idx) {
                res.add(Arrays.asList(idx, i));
            }
        }
    }

    private boolean isPal(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++; end--;
        }
        return true;
    }



    class Node {
        Node[] next;
        int index;
        List<Integer> list;

        public Node() {
            next = new Node[26];
            index = -1;
            list = new ArrayList<>();
        }
    }
}
