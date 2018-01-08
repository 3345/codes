package leetcode;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by fyl on 1/7/18.
 */
public class KthSmallestElementinaSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            int i1 = matrix[o1[1]][o1[0]];
            int i2 = matrix[o2[1]][o2[0]];
            return i1 - i2;
        });

        for (int i = 0; i < matrix[0].length; i++) {
            q.offer(new int[]{i, 0});
        }

        int[] top = null;
        while (k -- > 0) {
            top = q.poll();
            int sum = matrix[top[1]][top[0]];
            if (top[1] + 1 < matrix.length) {
                q.offer(new int[]{top[0], top[1] + 1});
            }
        }

        return matrix[top[1]][top[0]];
    }

    @Test
    public void test() {
        int[][] m = {{1,5,9},{10,11,13},{12,13,15}};
        int k = 8;
        kthSmallest(m, k);
    }
}
