package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * Created by fuyul on 12/17/2016.
 */
public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] a, int[][] b) {
        Map<Integer, Set<Integer>> mapA = new HashMap<>();
        Map<Integer, Set<Integer>> mapB = new HashMap<>();
        int[][] c = new int[a.length][b[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] != 0) {
                    if (mapA.containsKey(i)) {
                        mapA.get(i).add(j);
                    } else {
                        Set<Integer> s = new HashSet<>();
                        s.add(j);
                        mapA.put(i, s);
                    }
                }
            }
        }

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                if (b[i][j] != 0) {
                    if (mapB.containsKey(i)) {
                        mapB.get(i).add(j);
                    } else {
                        Set<Integer> s = new HashSet<>();
                        s.add(j);
                        mapB.put(i, s);
                    }
                }
            }
        }

        for (Integer i : mapA.keySet()) {
            for (Integer j : mapA.get(i)) {
                if (mapB.containsKey(j)) {
                    for (Integer k : mapB.get(j)) {
                        c[i][k] = c[i][k] + a[i][j] * b[j][k];
                    }
                }
            }
        }

        return c;
    }

    @Test
    public void t() {
        int[][] a = {{1,0,0},{-1,0,3}};
        int[][] b = {{7,0,0},{0,0,0},{0,0,1}};
        multiply(a, b);
    }
}
