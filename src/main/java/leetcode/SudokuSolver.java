package leetcode;

import org.junit.Test;

/**
 * Created by yulai on 10/24/15.
 */
public class SudokuSolver {
    char[][] board;

    public void solveSudoku(char[][] board) {
        this.board = board;

        boolean ok = doSolve(0, 0);
        System.out.print("sd");
    }

    public boolean doSolve(int i, int j) {
        if (i > 8 || j > 8) {
            return true;
        }

        if (board[j][i] == '.') {
            boolean solvable = false;

            for (Character k = Character.valueOf('1'); k <= Character.valueOf('1') + 8; k++) {
                board[j][i] = k;
                if (!isValidSudoku(board)) {
                    board[j][i] = '.';
                } else {

                    if (i == 8) {
                        solvable = doSolve(0, j + 1);
                    } else {
                        solvable = doSolve(i + 1, j);
                    }

                    if (!solvable) {
                        board[j][i] = '.';
                    } else {
                        return true;
                    }
                }
            }

            return solvable;
        } else {
            if (i == 8) {
                return doSolve(0, j + 1);
            } else {
                return doSolve(i + 1, j);
            }
        }
    }

    public boolean isValidSudoku(char[][] board) {

        for (int j = 0; j < 9; j++) {
            int[] map = new int[256];

            for (int i = 0; i < 9; i++) {
                if (board[j][i] == '.') {
                    continue;
                }

                if (map[board[j][i]] == 0) {
                    map[board[j][i]] = 1;
                    continue;
                } else {
                    return false;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            int[] map = new int[256];

            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') {
                    continue;
                }

                if (map[board[j][i]] == 0) {
                    map[board[j][i]] = 1;
                    continue;
                } else {
                    return false;
                }
            }
        }

        for (int i = 0; i <= 6; i += 3) {
            for (int j = 0; j <= 6; j += 3) {
                if (!isValidGrid(i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isValidGrid(int originX, int originY) {
        int[] map = new int[256];

        for (int j = originY; j < originY + 3; j++) {
            for (int i = originX; i < originX + 3; i++) {
                if (board[j][i] == '.') {
                    continue;
                }

                if (map[board[j][i]] == 0) {
                    map[board[j][i]] = 1;
                    continue;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    @Test
    public void test() {
    //["..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."]
        char[][] input = {"..9748...".toCharArray(),
                          "7........".toCharArray(),
                          ".2.1.9...".toCharArray(),
                          "..7...24.".toCharArray(),
                          ".64.1.59.".toCharArray(),
                          ".98...3..".toCharArray(),
                          "...8.3.2.".toCharArray(),
                          "........6".toCharArray(),
                          "...2759..".toCharArray()};

        SudokuSolver sol = new SudokuSolver();
        sol.solveSudoku(input);
        System.out.println("");
    }

}
