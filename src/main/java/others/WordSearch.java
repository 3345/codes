package others;

import org.junit.Test;

/**
 Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 For example,
 Given board =

 [
 ["ABCE"],
 ["SFCS"],
 ["ADEE"]
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null)
            return false;

        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
               if (search(copyBoard(board), word, i, j))
                   return true;
            }
        }

        return false;
    }

    public boolean search(char[][] board, String word, int x, int y) {
        if (word.isEmpty())
            return true;

        char target = word.charAt(0);


        if (board[x][y] != target)
            return false;

        word = word.substring(1, word.length());

        char[][] board1 = copyBoard(board);
        board1[x][y] = '#';

        if (x - 1 >= 0) {
            if (search(board1, word, x - 1, y))
                return true;
        }
        if (x + 1 < board.length) {
            if (search(board1, word, x + 1, y))
                return true;
        }
        if (y - 1 >= 0) {
            if (search(board1, word, x, y - 1))
                return true;
        }
        if (y + 1 < board[0].length) {
           if (search(board1, word, x, y + 1))
               return true;
        }
        return false;
    }

    private char[][] copyBoard(char[][] board) {
        char[][] newBoard = new char[board.length][board[0].length];
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                newBoard[i][j] = board[i][j];
            }
        }
        return newBoard;
    }

    @Test
    public void t() {
        char[][] board = new char[3][4];
        board[0] = "ABCE".toCharArray();
        board[1] = "SFCS".toCharArray();
        board[2] = "ADEE".toCharArray();

        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "SEE"));
        System.out.println(exist(board, "ABCB"));

    }

}
