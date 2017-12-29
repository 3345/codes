package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by fyl on 12/28/17.
 */
public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int len = A.length;
        Map<Integer, Integer> ab = new HashMap<>();
        Map<Integer, Integer> cd = new HashMap<>();
        int count = 0;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j ++) {
                int sum = A[i] + B[j];
                ab.put(sum, ab.getOrDefault(sum, 0) + 1);
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j ++) {
                int sum = C[i] + D[j];
                count += ab.getOrDefault(0 - sum, 0);
            }
        }

        return count;
    }
}
