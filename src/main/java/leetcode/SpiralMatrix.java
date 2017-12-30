package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }

        int h = matrix.length, w = matrix[0].length;

        int l = 0, r = w - 1, t = 0, b = h - 1;

        int x = 0, y = 0, step = 0;

        int dir = 0;

        while (step < h*w) {
            switch (dir) {
                case 0:
                    while (x >= l && x <= r) {
                        list.add(matrix[y][x]);
                        x++; step++;
                    }
                    x--;y++;t++;
                    break;

                case 1:
                    while (y >= t && y <= b) {
                        list.add(matrix[y][x]);
                        y++; step++;
                    }
                    x--;y--;r--;
                    break;

                case 2:
                    while (x >= l && x <= r) {
                        list.add(matrix[y][x]);
                        x--; step++;
                    }
                    x++;y--;b--;
                    break;

                case 3:
                    while (y >= t && y <= b) {
                        list.add(matrix[y][x]);
                        y--; step++;
                    }
                    x++;y++;l++;
                    break;
            }
            dir = (dir + 1) % 4;
        }

        return list;
    }

    @Test
    public void test() {
        int[][] a = new int[][]{new int[]{1,2,3}, new int[]{4,5,6}, new int[]{7,8,9}};
        spiralOrder(a);
    }
}
