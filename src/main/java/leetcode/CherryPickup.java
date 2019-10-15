package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by fuyul on 10/15/2019.
 */
public class CherryPickup {
    int[][] grid;
    int[][][] mem;
    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        int n = grid.length;
        mem = new int[n][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(mem[i][j], -2);
            }
        }
        int max = -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(dp(n-1, n-1, i), max);
        }
        return max;
    }


    // x1+y1=x2+y2 -> y2=x1+y1-x2
    private int dp(int x1, int y1, int x2) {
        int y2 = x1+y1-x2;

        if (this.mem[x1][y1][x2] > -2) {
            return this.mem[x1][y1][x2];
        }


        if (x1 < 0 || x2 < 0 || y1 < 0 || y2 < 0 || y2 >= this.grid.length) {
            return -1;
        }

        if (this.grid[y1][x1] == -1 || this.grid[y2][x2] == -1) {
            return -1;
        }

        int prevMax = dp(x1-1,y1,x2);
        prevMax = Math.max(prevMax, dp(x1,y1-1,x2));
        prevMax = Math.max(prevMax, dp(x1-1, y1, x2-1));
        prevMax = Math.max(prevMax, dp(x1, y1-1, x2-1));
        int max = prevMax + this.grid[y1][x1] + this.grid[y2][x2];
        if (x1 == x2 && y1 == y2) {
            max -= this.grid[y1][x1];
        }
        this.mem[x1][y1][x2] = max;
        return max;
    }

    @Test
    public void test() {
        int[][] in = new int[][]{{0,1,-1},{1,0,-1},{1,1,1}};
        cherryPickup(in);
    }
}
