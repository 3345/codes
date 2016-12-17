package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fuyul on 12/17/2016.
 */
public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] a, int[][] b) {
        Map<Integer, Map<Integer, Integer>> mapA = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> mapB = new HashMap<>();
        int[][] c = new int[a.length][b[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] != 0) {
                    if (mapA.containsKey(i)) {
                        mapA.get(i).put(j, a[i][j]);
                    } else {
                        Map<Integer, Integer> m = new HashMap<>();
                        m.put(j, a[i][j]);
                        mapA.put(i, m);
                    }
                }
            }
        }

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                if (b[i][j] != 0) {
                    if (mapB.containsKey(i)) {
                        mapB.get(i).put(j, b[i][j]);
                    } else {
                        Map<Integer, Integer> m = new HashMap<>();
                        m.put(j, b[i][j]);
                        mapB.put(i, m);
                    }
                }
            }
        }


    }
}
