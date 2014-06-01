package ch9;


public class p9_6 {
    public static boolean find (int[][] matrix, int target, int x, int y) {
        if (x < 0 || y > matrix[0].length)
            return false;

        if (matrix[x][y] == target)
            return true;

        if (matrix[x][y] > target)
            return find(matrix, target, x--, y);

        return find(matrix, target, x, y++);
    }
}
