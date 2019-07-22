package leetcode;

import java.util.*;

/**
 * Created by fyl on 7/16/19.
 */
public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int[] colorMap = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!bfs(graph, colorMap, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean bfs(int[][] graph, int[] colorMap, int initV) {
        if (colorMap[initV] != 0) {
            return true;
        }
        // vertex q
        Queue<Integer> vq = new LinkedList<>();
        // color q
        Queue<Integer> cq = new LinkedList<>();
        vq.add(initV);
        cq.add(1);

        while (!vq.isEmpty()) {
            int v = vq.poll();
            int c = cq.poll();
            int nc = -1 * c;
            //iter thru neighbor
            for (int n : graph[v]) {
                if (colorMap[n] == 0) {
                    colorMap[n] = nc;
                    vq.add(n);
                    cq.add(nc);
                } else if (colorMap[n] == c) {
                    return false;
                }
            }
        }

        return true;
    }

}
