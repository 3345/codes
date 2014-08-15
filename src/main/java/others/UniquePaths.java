package others;

import org.junit.Test;

/**
 A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 The robot can only move either down or right at any point in time.
 The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 How many possible unique paths are there?
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int [][] mem = new int[n][m];
        return path(m,n,0,0,mem);
    }
    public int path(int m, int n, int x, int y, int[][] mem) {
        if (mem[y][x] != 0)
            return mem[y][x];

        if (x == m - 1 && y == n - 1)
            return 1;

        int result = 0;
        if (x + 1 <= m - 1) {
            result = result + path(m, n, x + 1, y, mem);
        }
        if (y + 1 <= n - 1) {
            result = result + path(m, n, x, y + 1, mem);
        }
        mem[y][x] = result;
        return result;
    }

    @Test
    public void test() {
        System.out.println(uniquePaths(33,13));
    }

}
