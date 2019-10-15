package leetcode;

import org.junit.Test;

import java.util.*;

public class AlienDictionary {
    Map<Character, Set<Character>> graph = new HashMap<>();
    public String alienOrder(String[] words) {
        addWord(words[0]);
        for (int i = 1; i < words.length; i++) {
            addWord(words[i]);

            int j = 0;
            while (j < Math.min(words[i-1].length(), words[i].length()) && words[i-1].charAt(j) == words[i].charAt(j)) {
                j++;
            }
            if (j < Math.min(words[i-1].length(), words[i].length()) && words[i-1].charAt(j) != words[i].charAt(j)) {
                add(words[i-1].charAt(j), words[i].charAt(j));
            }
        }

        return topoSort();
    }

    private void addWord(String s) {
        for (Character c : s.toCharArray()) {
            graph.putIfAbsent(c, new HashSet<>());
        }
    }

    private void add(char c1, char c2) {
        graph.putIfAbsent(c1, new HashSet<>());
        graph.get(c1).add(c2);
    }

    private String topoSort() {
        Set<Character> visited = new HashSet<>();
        Set<Character> visiting = new HashSet<>();
        StringBuilder order = new StringBuilder();

        for (Character c : graph.keySet()) {
            if (!dfs(c, visited, visiting, order)) {
                return "";
            }
        }

        return order.reverse().toString();
    }

    private boolean dfs(Character c, Set<Character> visited, Set<Character> visiting, StringBuilder stack) {
        if (visited.contains(c)) {
            return true;
        }

        if (visiting.contains(c)) {
            return false;
        }

        visiting.add(c);
        for (Character next : this.graph.get(c)) {
            if (!dfs(next, visited, visiting, stack)) {
                return false;
            }
        }
        visited.add(c);
        stack.append(c);
        return true;
    }

    @Test
    public void test() {
        String[] input = new String[]{"ri","xz","qxf","jhsguaw","dztqrbwbm","dhdqfb","jdv","fcgfsilnb","ooby"};
        System.out.println(alienOrder(input));
    }
}
