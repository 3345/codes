package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by yfu on 8/7/14.
 */
public class UniquePathII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null)
            return 0;

        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int [][] mem = new int[n][m];
        for (int[] a : mem) {
            Arrays.fill(a, -1);
        }
        return path(m, n, obstacleGrid, 0, 0, mem);
    }
    public int path(int m, int n, int[][] obstacle, int x, int y, int[][] mem) {
        if (obstacle[y][x] == 1)
            return 0;

        if (x == m - 1 && y == n - 1)
            return 1;

        if (mem[y][x] != -1)
            return mem[y][x];

        int result = 0;

        if (x + 1 <= m - 1) {
            result = result + path(m, n, obstacle, x + 1, y, mem);
        }
        if (y + 1 <= n - 1) {
            result = result + path(m, n, obstacle, x, y + 1, mem);
        }
        mem[y][x] = result;
        return result;
    }

    @Test
    public void test() {
        int[][] a = new int[1][2];
        a[0][0] = 0;
        a[0][1] = 1;
        System.out.println(uniquePathsWithObstacles(a));
    }


}
