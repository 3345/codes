package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSquare {
    TrieNode root;
    int len;
    char[][] visited;
    List<List<String>> output = new ArrayList<>();
    public List<List<String>> wordSquares(String[] words) {
        this.root = TrieNode.buildTrie(words);
        len = words[0].length();
        visited = new char[len][len];
        return output;
    }

    private void backtrace(int step) {
        if (step == len) {
            List<String> result = new HashMap<>();
            for (char[] row : visited) {
                result.add(new String(row));
            }
            return;
        }
        String prefix = new String(visited[step]);
        List<String> cans = TrieNode.find(root, prefix);
        for (String can : cans) {
            for (int i = step; i < len; i++) {
                visited[step][i] = can.charAt(i);
                visited[i][step] = can.charAt(i);
            }
            backtrace(step+1);
            for (int i = step; i < len; i++) {
                visited[step][i] = 0;
                visited[i][step] = 0;
            }
        }
    }

    public static class TrieNode {
        char c;
        boolean end = false;
        Map<Character, TrieNode> children = new HashMap<>();
        public TrieNode(char c) {
            this.c = c;
        }

        public static TrieNode buildTrie(String[] words) {
            TrieNode root = new TrieNode('#');
            for (String w : words) {
                TrieNode cur = root;
                for (int i = 0; i < w.length(); i++) {
                    char c = w.charAt(i);
                    cur.children.putIfAbsent(c, new TrieNode(c));
                    cur = cur.children.get(c);
                    if (i == w.length() - 1) {
                        cur.end = true;
                    }
                }
            }
            return root;
        }

        public static List<String> find(TrieNode node, String target) {
            List<String> res = new ArrayList<>();
            findHelper(node, target, "", res);
            return res;
        }

        public static void findHelper(TrieNode node, String target, String cur, List<String> res) {
            if (target.isEmpty()) {
                res.add(cur);
                return;
            }
            char c = target.charAt(0);
            if (c == node.c) {
                for (TrieNode child : node.children.values()) {
                    findHelper(child, target.substring(1), cur+c, res);
                }
            }
        }
    }
}
