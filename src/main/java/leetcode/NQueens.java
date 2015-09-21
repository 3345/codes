package leetcode;

import org.junit.Test;

import java.util.*;

/**
 Given an integer n, return all distinct solutions to the n-queens puzzle.

 Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

 For example,
 There exist two distinct solutions to the 4-queens puzzle:
 [
 [".Q..",  // Solution 1
 "...Q",
 "Q...",
 "..Q."],

 ["..Q.",  // Solution 2
 "Q...",
 "...Q",
 ".Q.."]
 ]
*/
public class NQueens {
    class Board {
        Set<Position> board;
        int n;
        Position currentPosition;

        public Board(int n) {
            this.n = n;
            board = new HashSet<Position>();
            this.currentPosition = new Position(0, 0);
        }

        public void addQ(int x, int y) {
            board.add(new Position(x, y));
        }

        public void removeQ(int x, int y) {
            board.remove(new Position(x, y));
        }

        public boolean contains(int x, int y) {
            return board.contains(new Position(x, y));
        }

        public boolean isValid(int x, int y) {
            Position pos = new Position(x, y);
            for (Position p : board) {
                if (p.x == pos.x || p.y == pos.y || Math.abs(p.x - pos.x) == Math.abs(p.y - pos.y))
                    return false;
            }
            return true;
        }

        public void goNextPosition(Position p) {
            currentPosition = p.nextPosition();
        }

        public String[] toStringArray() {
            String[] result = new String[n];
            for (int i = 0; i < n; i ++) {
                StringBuilder row = new StringBuilder();
                for (int j = 0; j < n; j ++) {
                    if (this.contains(i, j))
                        row.append('Q');
                    else
                        row.append('.');
                }
                result[i] = new String(row);
            }
            return result;
        }

        class Position {
            int x;
            int y;

            public Position() {}

            public Position(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public Position nextPosition() {
                if (x == n - 1 && y == n - 1)
                    return null;

                Position result = new Position();
                if (x < n - 1) {
                    result.x = x + 1;
                    result.y = y;
                }
                else if (y < n - 1) {
                    result.x = 0;
                    result.y = y + 1;
                }
                return result;
            }

            @Override
            public int hashCode() {
                int result = x;
                result = 31*result + y;
                return result;
            }

            @Override
            public boolean equals(Object o) {
                Position target = (Position)o;
                return (x == target.x && y == target.y);
            }
        }
    }



    public List<String[]> solveNQueens(int n) {
        List<String[]> result = new ArrayList<String[]>();
        Board board = new Board(n);
        solve(board, n, result);
        return result;
    }

    public void solve(Board board, int left, List<String[]> result) {
        if (left == 0) {
            result.add(board.toStringArray());
            return;
        }

        while (board.currentPosition != null) {
            Board.Position p = board.currentPosition;
            if (board.isValid(p.x, p.y)) {
                board.addQ(p.x, p.y);
                solve(board, left - 1, result);
                board.removeQ(p.x, p.y);
            }
            board.goNextPosition(p);
        }
    }


    @Test
    public void test() {
        List<String[]> result = solveNQueens(15);
        System.out.println(result.size());
    }
}


