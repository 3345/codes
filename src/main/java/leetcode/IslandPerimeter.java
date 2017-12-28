package leetcode;

import org.junit.Test;

/**
 * Created by fyl on 12/27/17.
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int p = 0;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == 0) {
                    continue;
                }

                if (x == 0 || grid[y][x-1] == 0) {
                    p++;
                }

                if (x == grid[0].length - 1 || grid[y][x+1] == 0) {
                    p++;
                }

                if (y == 0 || grid[y - 1][x] == 0) {
                    p++;
                }

                if (y == grid.length - 1 || grid[y+1][x] == 0) {
                    p++;
                }
            }
        }

        return p;
    }

    @Test
    public void test() {
        int r1[] = new int[] {1,0};
        int[][] grid = new int[][] {r1};
        System.out.print(islandPerimeter(grid));
    }
}
