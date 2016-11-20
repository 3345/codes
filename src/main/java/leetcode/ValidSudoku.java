package leetcode;

/**
 * Created by yulai on 10/21/15.
 */
public class ValidSudoku {
    char[][] board;

    public boolean isValidSudoku(char[][] board) {
        this.board = board;

        for (int j = 0; j < 9; j ++) {
            int[] map = new int[256];

            for (int i = 0; i < 9; i ++) {
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

        for (int i = 0; i < 9; i ++) {
            int[] map = new int[256];

            for (int j = 0; j < 9; j ++) {
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
            for (int j = 0; j <= 6; j+= 3) {
                if (!isValidGrid(i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isValidGrid(int originX, int originY) {
        int[] map = new int[256];

        for (int j = originY; j < originY + 3; j ++) {
            for (int i = originX; i < originX + 3; i ++) {
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
}
