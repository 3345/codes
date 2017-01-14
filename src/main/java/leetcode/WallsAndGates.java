package leetcode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by fyl on 1/12/17.
 */
public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            return;
        }

        int h = rooms.length;
        int w = rooms[0].length;

        if (w == 0) {
            return;
        }


        Queue<int[]> q = new LinkedList<>();

        for (int j = 0; j < h; j++) {
            for (int i = 0; i < w; i++) {
                if (rooms[j][i] == 0) {
                    q.offer(new int[]{i, j, 0});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] n = q.poll();
            exploreFour(n[0], n[1], n[2] + 1, rooms, q);
        }
    }



    private void exploreFour(int i, int j, int d, int[][] rooms, Queue<int[]> q) {
        if (needUpdate(i - 1, j, d, rooms)) {
            q.offer(new int[]{i - 1, j, d});
            rooms[j][i - 1] = d;
        }

        if (needUpdate(i + 1, j, d, rooms)) {
            q.offer(new int[]{i + 1, j, d});
            rooms[j][i + 1] = d;
        }

        if (needUpdate(i, j - 1, d, rooms)) {
            q.offer(new int[]{i, j - 1, d});
            rooms[j - 1][i] = d;
        }

        if (needUpdate(i, j + 1, d, rooms)) {
            q.offer(new int[]{i, j + 1, d});
            rooms[j + 1][i] = d;
        }
    }

    public boolean needUpdate(int i, int j, int d, int[][] rooms) {
        if (i < 0 || i > rooms[0].length - 1 || j < 0 || j > rooms.length - 1 || rooms[j][i] == -1 || rooms[j][i] == 0 || rooms[j][i] <= d) {
            return false;
        }

        return true;
    }


    @Test
    public void t() {
        int[][] a = new int[][] {{2147483647,0,2147483647,2147483647,0,2147483647,-1,2147483647}};

        wallsAndGates(a);
    }


}
