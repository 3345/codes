package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSquare {
    Trie trie;
    int len;
    char[][] visited;
    List<List<String>> output = new ArrayList<>();

    public List<List<String>> wordSquares(String[] words) {
        this.trie = new Trie(words);
        len = words[0].length();
        visited = new char[len][len];
        backtrace(0);
        return output;
    }

    private void backtrace(int step) {
        if (step == len) {
            List<String> result = new ArrayList<>();
            for (char[] row : visited) {
                result.add(new String(row));
            }
            output.add(result);
            return;
        }
        String prefix = buildString(visited[step]);
        List<String> cans = this.trie.find(prefix);
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

    private String buildString(char[] arr) {
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if (c == 0) {
                break;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public class Trie {
        TrieNode root;
        public Trie(String[] words) {
            root = new TrieNode('#');
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
        }

        public List<String> find(String target) {
            List<String> res = new ArrayList<>();
            for (TrieNode child : root.children.values()) {
                findHelper(child, target, "", res);
            }
            return res;
        }

        public void findHelper(TrieNode node, String target, String cur, List<String> res) {
            if (node.end) {
                cur += node.c;
                res.add(cur);
                return;
            }

            if (target.isEmpty() || target.charAt(0) == node.c) {
                for (TrieNode child : node.children.values()) {
                    String t = target.isEmpty() ? "" : target.substring(1);
                    String c = node.c == '#' ?  "" : node.c+"";
                    findHelper(child, t, cur+c, res);
                }
            }
        }

    }

    public class TrieNode {
        char c;
        boolean end = false;
        Map<Character, TrieNode> children = new HashMap<>();

        public TrieNode(char c) {
            this.c = c;
        }

    }

    @Test
    public void test() {
        String[] words = new String[]{"area","lead","wall","lady","ball"};
        wordSquares(words);
    }
}
