package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by fyl on 1/23/17.
 */
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        if (edges == null || edges.length == 0) {
            return true;
        }

        for (int i = 0; i < edges.length; i ++) {
            int min = Math.min(edges[i][0], edges[i][1]);
            int max = Math.max(edges[i][0], edges[i][1]);

            if (map.containsKey(min)) {
                map.get(min).add(max);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(max);
                map.put(min, set);
            }
        }

        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();


    }

    public boolean recur(Map<Integer, Set<Integer>> map, Set<Integer> visiting, Set<Integer> visited, Integer cur) {
        if (visited.contains(cur)) {
            return true;
        }

        if (visiting.contains(cur)) {
            return false;
        }

        visiting.add(cur);

        for (Integer v : map.get(cur)) {

        }


    }
}
