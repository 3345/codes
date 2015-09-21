package leetcode;

import org.junit.Test;

import java.util.*;

/**
Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start
to end, such that: Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
Given:
        start = "hit"
        end = "cog"
        dict = ["hot","dot","dog","lot","log"]
        As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
        return its length 5.
 */
public class WordLadder {
    public class Node {
        public ArrayList<String> visited;
        public String word;

        public Node () {}

        public Node (ArrayList<String> visited, String word) {
            this.visited = visited;
            this.word = word;
        }
    }

    public int ladderLength(String start, String end, Set<String> dict) {
        if (!dict.contains(start) || !dict.contains(end))
            return 0;

        LinkedList<Node> queue = new LinkedList();

        ArrayList<String> visited = new ArrayList<String>();
        visited.add(start);
        queue.addFirst(new Node(visited, start));

        while (!queue.isEmpty()) {
            Node node = queue.pop();
            for (String s : dict) {
                if (s.equals(end) && canTransform(node.word, s))
                    return node.visited.size() + 1;

                if (!node.visited.contains(s) && canTransform(node.word, s)) {
                    ArrayList<String> nextVisited = new ArrayList<String>();
                    nextVisited.addAll(node.visited);
                    nextVisited.add(s);
                    queue.addFirst(new Node(nextVisited, s));
                }
            }
        }
        return 0;
    }

    private boolean canTransform(String start, String end) {
        if (start.length() != end.length())
            return false;

        int diff = 0;
        for (int i = 0; i < start.length(); i ++) {
            if (start.charAt(i) != end.charAt(i))
                diff ++;
            if (diff > 1)
                break;;
        }

        return diff == 1;

    }

    @Test
    public void t1() {
        System.out.println(canTransform("hot", "dog"));
    }

    @Test
    public void t2() {
        Set<String> set = new HashSet<String>(Arrays.asList("a", "b", "c"));
        System.out.println(ladderLength("a", "c", set));
    }

    @Test
    public void t3() {
        Set<String> set = new HashSet<String>(Arrays.asList("hot", "dog"));
        System.out.println(ladderLength("hot", "dog", set));
    }
}
