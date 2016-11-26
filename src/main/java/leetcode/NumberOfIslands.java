package leetcode;

import org.junit.Test;

/**
 * Created by fyl on 11/26/16.
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int h = grid.length;
        int w = grid[0].length;
        int count = 0;

        int[][] visited = new int[h][w];

        for(int j = 0; j < h; j++) {
            for (int i = 0; i < w; i ++) {
                if (grid[j][i] == '1' && visited[j][i] == 0) {
                    count++;
                    expand(i, j, grid, visited);
                }
            }
        }

        return count;
    }

    private void expand(int i, int j, char[][] grid, int[][] visited) {
        int h = grid.length;
        int w = grid[0].length;

        if (i < 0 ||i >= w || j < 0 || j >= h || grid[j][i] == '0' || visited[j][i] == 1) {
            return;
        }

        visited[j][i] = 1;

        expand(i - 1, j, grid, visited);
        expand(i + 1, j, grid, visited);
        expand(i, j - 1, grid, visited);
        expand(i, j + 1, grid, visited);
    }

    @Test
    public void test() {
        char[][] input = {"11110".toCharArray(),"11010".toCharArray(),"11000".toCharArray(),"00000".toCharArray()};

        System.out.print(numIslands(input));
    }
}
