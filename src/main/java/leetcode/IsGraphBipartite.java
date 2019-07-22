package leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        return dfs(graph, new int[graph.length], new int[graph.length], 0);
    }

    private boolean dfs(int[][] graph, int[] set1, int[] set2, int n1) {
        if (n1 > graph.length - 1) {
            return true;
        }
        if (check(graph[n1], set1)) {
            set1[n1]=1;
            if (dfs(graph, set1, set2, n1+1)) {
                return true;
            } else {
                set1[n1]=0;
            }
        }
        if (check(graph[n1], set2)) {
            set2[n1]=1;
            if (dfs(graph, set1, set2, n1+1)) {
                return true;
            } else {
                set2[n1]=0;
            }
        }
        return false;
    }

    // check if a node whose neighbors are n2s can be put in putSet
    private boolean check(int[] n2s, int[] putSet) {
        for (int n2 : n2s) {
            if (putSet[n2] == 1) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        int[][] g = new int[][]{{7},{9},{6,9},{},{5},{4},{2},{0},{},{1,2},{15,16},{15,18,19},{15,17,18,19},{15,16,17,18,19},{15,16,17},{10,11,12,13,14},{10,13,14},{12,13,14},{11,12,13},{11,12,13},{25,27,29},{26,27,28,29},{25,26,29},{25,27,29},{25,26,27,28},{20,22,23,24},{21,22,24},{20,21,23,24},{21,24},{20,21,22,23},{35,36,38},{35,36,37},{35,36,38},{36,37,38,39},{36,37,39},{30,31,32},{30,31,32,33,34},{31,33,34},{30,32,33},{33,34},{45,48,49},{46,47,48},{45,46,47},{45,47,48,49},{45,46,47,49},{40,42,43,44},{41,42,44},{41,42,43,44},{40,41,43},{40,43,44},{57,58},{},{},{57},{57,59},{},{},{50,53,54},{50},{54},{67,68},{65,68},{66,69},{65,66,67},{65},{61,63,64},{62,63},{60,63},{60,61},{62},{78},{75,77,79},{75,76},{},{},{71,72},{72},{71},{70},{71},{},{86},{86,89},{},{86},{},{81,82,84},{},{},{82},{91,92,93,94,95,97,99},{90,92,93,94,95,96,98,99},{90,91,93,94,95,96},{90,91,92,94,95,96,97,98,99},{90,91,92,93,95,99},{90,91,92,93,94,96,99},{91,92,93,95,97},{90,93,96,98,99},{91,93,97,99},{90,91,93,94,95,97,98}};
        IsGraphBipartite sol = new IsGraphBipartite();
        boolean ans = sol.isBipartite(g);
        System.out.println(ans);
    }

}
