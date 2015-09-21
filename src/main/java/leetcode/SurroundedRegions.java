package leetcode;

import org.junit.Test;

/**
 Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 For example,
 X X X X
 X O O X
 X X O X
 X O X X
 After running your function, the board should be:

 X X X X
 X X X X
 X X X X
 X O X X
 */

public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board.length == 0)
            return;
        for (int j = 0; j < board[0].length; j ++) {
            //left edge
            if (board[0][j] == 'O') {
                board[0][j] = '#';
                fill(board, 0, j, '#');
            }
            //right edge
            if (board[board.length - 1][j] == 'O') {
                board[board.length - 1][j] = '#';
                fill(board, board.length - 1, j, '#');
            }
        }

        for (int i = 0; i < board.length; i ++) {
            //top edge
            if (board[i][0] == 'O') {
                board[i][0] = '#';
                fill(board, i, 0, '#');
            }
            //bot edge
            if (board[i][board[0].length - 1] == 'O') {
                board[i][board[0].length - 1] = '#';
                fill(board, i, board[0].length - 1, '#');
            }
        }

        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void fill(char[][] board, int x, int y, char c) {
        if (x - 1 > 0 && board[x - 1][y] == 'O') {
            board[x - 1][y] = c;
            fill(board, x - 1, y, c);
        }
        if (y - 1 > 0 && board[x][y - 1] == 'O') {
            board[x][y - 1] = c;
            fill(board, x, y - 1, c);
        }
        if (x + 1 < board.length && board[x + 1][y] == 'O') {
            board[x + 1][y] = c;
            fill(board, x + 1, y, c);
        }
        if (y + 1 < board[0].length && board[x][y + 1] == 'O') {
            board[x][y + 1] = c;
            fill(board, x, y + 1, c);
        }
    }

    @Test
    public void t1() {
        char[][] board = new char[3][3];
        board[0] = "OOO".toCharArray();
        board[1] = "OOO".toCharArray();
        board[2] = "OOO".toCharArray();

        solve(board);
        System.out.println();
    }
}
