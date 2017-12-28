package leetcode;

import org.junit.Test;

/**
 * Created by fyl on 12/27/17.
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        for(int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (board[y][x] % 10 == 1) {
                    if (x > 0 && y > 0) {
                        board[y - 1][x - 1] += 10;
                    }

                    if (y < board.length - 1) {
                        board[y + 1][x] += 10;
                    }

                    if (x > 0) {
                        board[y][x - 1] += 10;
                    }

                    if (x < board[0].length - 1) {
                        board[y][x + 1] += 10;
                    }

                    if (y > 0) {
                        board[y - 1][x] += 10;
                    }

                    if (y > 0 && x < board[0].length - 1) {
                        board[y-1][x+1] += 10;
                    }

                    if (y < board.length - 1 && x < board[0].length - 1) {
                        board[y+1][x+1] += 10;
                    }

                    if (x > 0 && y < board.length - 1) {
                        board[y + 1][x - 1] += 10;
                    }
                }
            }
        }

        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                int state = board[y][x] % 10;
                int neighbor = board[y][x] / 10;

                if (neighbor < 2) {
                    board[y][x] = 0;
                }

                if (neighbor == 2) {
                    board[y][x] = state;
                }

                if (neighbor == 3) {
                    board[y][x] = 1;
                }

                if (neighbor > 3) {
                    board[y][x] = 0;
                }
            }
        }
    }

    @Test
    public void test() {
        int[] a = new int[]{1,1};
        int[] b = new int[]{1,0};
        int[][] c = new int[][]{a,b};

        gameOfLife(c);
    }
}
