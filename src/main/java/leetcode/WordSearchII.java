package leetcode;

import lintcode.*;

import java.util.*;

/**
 * Created by fyl on 7/21/19.
 */
public class WordSearchII {
    TrieNode dict = new TrieNode();
    char[][]board;
    char[][] visited;
    Set<String> output = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        visited = new char[board.length][board[0].length];

        for (String w : words) {
            TrieNode cur = this.dict;
            for (Character c : w.toCharArray()) {
                if (cur.children.containsKey(c)) {
                    cur = cur.children.get(c);
                } else {
                    TrieNode node = new TrieNode(c);
                    cur.children.put(c, node);
                    cur = node;
                }
            }
            cur.end = true;
        }

        for (int j = 0; j < board.length; j++) {
            for (int i = 0; i < board[0].length; i++) {
                this.backtrace(i, j, dict, "");
            }
        }
        return new ArrayList<>(output);
    }

    public void backtrace(int i, int j, TrieNode p, String cur) {
        if (i < 0 || i >= board[0].length || j < 0 || j >= board.length) {
            return;
        }
        if (this.visited[j][i] == 1) {
            return;
        }

        char c = this.board[j][i];
        if (!p.children.containsKey(c)) {
            return;
        }
        TrieNode n = p.children.get(c);
        String s = cur+c;
        if (n.end) {
            output.add(s);
        }
        visited[j][i] = 1;
        backtrace(i + 1, j, n, s);
        backtrace(i, j + 1, n, s);
        backtrace(i - 1, j, n, s);
        backtrace(i, j - 1, n, s);
        visited[j][i] = 0;
    }

    public class TrieNode {
        char val;
        Map<Character, TrieNode> children;
        boolean end;

        public TrieNode () {
            this.val = 0;
            this.children = new HashMap<>();
        }

        public TrieNode(char val) {
            this.val = val;
            this.children = new HashMap<>();
        }
    }
}
