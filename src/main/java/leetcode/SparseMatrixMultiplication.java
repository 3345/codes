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
    }
}
