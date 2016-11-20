package leetcode;

import org.junit.Test;

/**
 * Created by fyl on 11/20/16.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int h = grid.length;
        if (h < 1) return 0;

        int w = grid[0].length;
        if (w < 1) return 0;

        int[][] cost = new int[h][w];
        cost[0][0] = 0;

        for(int i = 1; i < w; i ++) {
            cost[0][i] = cost[0][i - 1] + grid[0][i - 1];
        }

        for (int i = 1; i < h; i ++) {
            cost[i][0] = cost[i - 1][0] + grid[i - 1][0];
        }

        int diag = Math.min(w, h);

        for (int s = 1; s < diag; s ++) {
            cost[s][s] = Math.min(cost[s - 1][s] + grid[s -1][s], cost[s][s-1] + grid[s][s-1]);

            for (int i = s + 1; i < w; i ++) {
                cost[s][i] = Math.min(cost[s - 1][i] + grid[s -1][i], cost[s][i-1] + grid[s][i-1]);
            }

            for (int i = s + 1; i < h; i ++) {
                cost[i][s] = Math.min(cost[i - 1][s] + grid[i -1][s], cost[i][s-1] + grid[i][s-1]);
            }
        }

        return cost[h-1][w-1] + grid[h-1][w-1];
    }

    @Test
    public void t0() {
        int[][] input = {{1,2,5},{3,2,1}};

        System.out.println(minPathSum(input));
    }
}
