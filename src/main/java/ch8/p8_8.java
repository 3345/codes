package ch8;

import org.junit.Test;

public class p8_8 {
    public int[][] nQueen(int[][] board, int left) {
        if (left == 0)
            return board;

        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board.length; j ++) {
                if (isValid(i, j, board)) {
                    board[i][j] = 1;
                    int[][] newBoard = board.clone();
                    int [][] result = nQueen(newBoard, left - 1);
                    if (result != null)
                        return result;
                    board[i][j] = 0;
                }
            }
        }

        return null;
    }

    private boolean isValid(int i, int j, int[][] board) {
        for (int k = 0; k < board.length; k ++) {
            for (int l = 0; l < board.length; l ++) {
                if (k == i || l == j || Math.abs(k - i) == Math.abs(l - j)) {
                    if (board[k][l] != 0)
                        return false;
                }
            }

        }

        return true;
    }

    @Test
    public void t1() {
        int n = 5;
        int[][] newBoard = new int[n][n];

//        for (int i = 0; i < newBoard.length; i ++) {
//            for (int j = 0; j < newBoard.length; j++) {
//                newBoard[i][j] = 0;
//            }
//        }

        int[][] result = nQueen(newBoard, n);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
