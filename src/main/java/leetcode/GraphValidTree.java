package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by fyl on 1/23/17.
 * slow!!!!!!!!!!!!!!!!!!
 */
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (edges == null || edges.length == 0) {
            return n == 0;
        }

        Map<Integer, Set<Integer>> unions = new HashMap<>();

        for(int i = 0; i < edges.length; i++) {
            int e1 = edges[i][0];
            int e2 = edges[i][1];

            if (!unions.containsKey(e1)) {
                Set<Integer> set = new HashSet<>();
                set.add(e1);
                unions.put(e1, set);
            }

            if (!unions.containsKey(e2)) {
                Set<Integer> set = new HashSet<>();
                set.add(e2);
                unions.put(e2, set);
            }



        }
        for(int i = 0; i < edges.length; i++) {
            Set<Integer> set1 = unions.get(edges[i][0]);
            Set<Integer> set2 = unions.get(edges[i][1]);

            for (Integer e1 : set1) {
                if (set2.contains(e1)) {
                    return false;
                }

                set2.add(e1);
                unions.put(e1, set2);
            }
        }

        return unions.get(0).size() == n;

    }

}
