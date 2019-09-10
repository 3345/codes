package leetcode;

import org.junit.Test;

/**
 * Created by fyl on 11/26/16.
 */
public class NumberOfIslands {
    int[][] v;
    char[][] g;
    int h;
    int w;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        h = grid.length;
        w = grid[0].length;

        g = grid;
        v = new int[h][w];
        int c = 0;

        for (int j = 0; j < h; j++) {
            for (int i = 0; i < w; i++) {
                if (g[j][i] == '1' && v[j][i] == 0) {
                    c++;
                    dfs(i, j);
                }
            }
        }

        return c;
    }

    private void dfs(int i, int j) {
        if (i < 0 || i >= w || j < 0 || j >= h) return;
        if (v[j][i] != 0 || g[j][i] == '0') return;
        v[j][i] = 1;
        dfs(i+1, j);
        dfs(i-1, j);
        dfs(i, j+1);
        dfs(i, j-1);
    }

    @Test
    public void test() {
        char[][] input = {"11110".toCharArray(),"11010".toCharArray(),"11000".toCharArray(),"00000".toCharArray()};

        System.out.print(numIslands(input));
    }
}
