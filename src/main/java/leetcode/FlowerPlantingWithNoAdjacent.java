package leetcode;

import org.junit.Test;

import java.util.*;

/**
 * Created by fyl on 8/2/19.
 */
public class FlowerPlantingWithNoAdjacent {
    int[] ans;

    public int[] gardenNoAdj(int N, int[][] paths) {
        this.ans = new int[N];

        for (int i = 0 ; i < N; i++) {
            this.ans[i] = 1;
        }
        TreeMap<Integer, List<Integer>> tm = new TreeMap<>();
        for (int[] p : paths) {
            if (p[0] > p[1]) {swap(p);}
            tm.putIfAbsent(p[0], new ArrayList<>());
            tm.get(p[0]).add(p[1]);
        }
        Set set = tm.entrySet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, List<Integer>> me = (Map.Entry)it.next();
            int key = me.getKey();
            List<Integer> val = me.getValue();

            for (int v : val) {

                    ans[v-1] = ans[key-1]+1;

            }
        }
        return ans;
    }

    private void swap(int[] a) {
        int t = a[0];
        a[0] = a[1];
        a[1] = t;
    }

    @Test
    public void test() {
        int[][] paths = new int[][]{{6,4},{6,1},{3,1},{4,5},{2,1},{5,6},{5,2}};
        gardenNoAdj(6, paths);
    }
}
