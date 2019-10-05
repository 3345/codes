package leetcode;

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
            };
            if (j < words[i-1].length() - 1 && j < words[i].length() - 1) {
                add(words[i-1].charAt(j+1), words[i].charAt(j+1));
            }
        }

        return topoSort();
    }

    private void addWord(String s) {
        char c = s.charAt(0);
        graph.putIfAbsent(c, new HashSet<>());
        for (int i = 1; i <s.length(); i++) {
            add(s.charAt(i-1), s.charAt(i));
        }
    }

    private void add(char c1, char c2) {
        graph.putIfAbsent(c1, new HashSet<>());
        graph.get(c1).add(c2);
    }

    private String topoSort() {
        Set<Character> visited = new HashSet<>();
        Set<Character> visiting = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        StringBuilder order = new StringBuilder();

        for (Character c : graph.keySet()) {
            dfs(c, visited, visiting, stack);
        }

        while (!stack.empty()) {
            order.append(stack.pop());
        }

        return order.toString();
    }

    private void dfs(Character c, Set<Character> visited, Set<Character> visiting, Stack<Character> stack) {
        if (visited.contains(c)) {
            return;
        }

        if (visiting.contains(c)) {
            stack.clear();
            return;
        }

        visiting.add(c);
        for (Character next : this.graph.get(c)) {
            dfs(next, visited, visiting, stack);
        }
        visited.add(c);
        stack.push(c);
    }
}
