package leetcode;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.*;

/**
 * Created by fyl on 11/30/16.
 */
public class WordLadderII {
    public class Node {
        public String val;
        public Node prev;

        public Node(String s) {
            this.val = s;
        }

    }

    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        wordList.add(endWord);
        LinkedList<Node> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        List<Node> ans = new ArrayList<>();
        List<List<String>> ret = new ArrayList<>();

        Node root = new Node(beginWord);
        q.add(root);
        q.add(new Node(null));
        boolean terminate = false;

        while (!q.isEmpty()) {
            Node nn = q.removeFirst();
            List<Node> sameLevelNodes = new ArrayList<>();

            while(nn.val != null) {
                sameLevelNodes.add(nn);
                nn = q.removeFirst();
            }

            boolean hasAdded = false;

            Set<String> levelVisited = new HashSet<>();

            for (Node n : sameLevelNodes) {
                if (n.val.equals(endWord)) {
                    terminate = true;
                    ans.add(n);
                } else {
                    List<String> transformed = transform(n.val, wordList, visited, levelVisited);
                    for (String t : transformed) {
                        Node tn = new Node(t);
                        tn.prev = n;
                        q.addLast(tn);
                        hasAdded = true;
                    }

                }
            }

            visited.addAll(levelVisited);

            if (terminate) {
                break;
            }

            if (hasAdded) {
                q.addLast(new Node(null));
            }

        }

        for (Node n : ans) {
            LinkedList<String> list = new LinkedList<>();
            while (n != null) {
                list.addFirst(n.val);
                n = n.prev;
            }
            ret.add(list);

        }

        return ret;

    }

    private List<String> transform(String word, Set<String> wordList, Set<String> visited, Set<String> levelVisted) {
        char[] a = word.toCharArray();
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < word.length(); i ++) {
            char original = a[i];

            for (char c = 'a'; c <= 'z'; c++) {
                if (original != c) {
                    a[i] = c;
                    String s = new String(a);
                    if ((!visited.contains(s) && wordList.contains(s))) {
                            levelVisted.add(s);


                        ans.add(s);
                    }
                }
            }

            a[i] = original;
        }

        return ans;
    }

    @Test
    public void t() {
        String begin = "hit";
        String end = "cog";
        Set<String> set = new HashSet<>(Arrays.asList("hot","dot","dog","lot","log"));

        List<List<String>> o = findLadders(begin, end, set);
        System.out.println(new Gson().toJson(o));

    }

    @Test
    public void t1() {
        String begin = "hot";
        String end = "dog";
        Set<String> set = new HashSet<>(Arrays.asList("hot","dog"));

        List<List<String>> o = findLadders(begin, end, set);
        System.out.println(new Gson().toJson(o));
    }

}
