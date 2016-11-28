package leetcode;

/**
 * Created by fyl on 11/27/16.
 */
public class Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        return doSearch(matrix, target, 0, 0, matrix[0].length - 1, matrix.length - 1);
    }

    /**
     *
     * @param matrix
     * @param target
     * @param x1 x of upper left
     * @param y1 y of upper left
     * @param x2 x of lower right
     * @param y2 y of lower right
     * @return
     */
    public boolean doSearch(int[][] matrix, int target, int x1, int y1, int x2, int y2) {
        int w = x2 - x1 + 1;
        int h = y2 - y1 + 1;
        //diagonal len
        int d = Math.min(w, h) ;

        //pivot point for next iteration, +1 needed
        int x = -1;
        int y = -1;

        if (d == 1) {
            if (matrix[y1][x1] == target) {
                return true;
            }
            x = x1;
            y = y1;
        } else {
            int[] coord = bs(matrix, target, x1, y1, d);
            x = coord[0];
            y = coord[1];

            if (matrix[y][x] == target) {
                return  true;
            }

        }


        //lower right
        int lrx1 = x + 1;
        int lry1 = y + 1;
        int lrx2 = x2;
        int lry2 = y2;

        if(checkBound(matrix, lrx1, lry1, lrx2, lry2)) {
            if (doSearch(matrix, target, lrx1, lry1, lrx2, lry2)) {
                return true;
            }
        }

        //upper right
        int urx1 = x + 1;
        int ury1 = y1;
        int urx2 = x2;
        int ury2 = y;

        if(checkBound(matrix, urx1, ury1, urx2, ury2)) {
            if (doSearch(matrix, target, urx1, ury1, urx2, ury2)) {
                return true;
            }
        }

        //bot left
        int blx1 = x1;
        int bly1 = y + 1;
        int blx2 = x;
        int bly2 = y2;

        if(checkBound(matrix, blx1, bly1, blx2, bly2)) {
            if (doSearch(matrix, target, blx1, bly1, blx2, bly2)) {
                return true;
            }
        }

        return false;

    }

    /**
     * @return the largest value smaller or equal to target
     */
    public int[] bs(int[][] matrix, int target, int x1, int y1, int len) {
        int x2 = x1 + len - 1;
        int y2 = y1 + len - 1;

        if (len == 1) {
            return new int[] {x1, y1};
        }

        int xm = x1 + len/2;
        int ym = y1 + len/2;

        if (matrix[ym][xm] == target) {
            return new int[] {xm, ym};
        } else if (matrix[ym][xm] < target) {
            return bs(matrix, target, xm, ym, x2 - xm + 1);
        } else {
            return bs(matrix, target, x1, y1, xm - 1 - x1 + 1);
        }

    }

    public boolean checkBound(int[][] matrix, int x, int y, int x1, int y1) {
        int h = matrix.length;
        int w = matrix[0].length;

        return x > -1 && y > -1 && x < w && y < h && x1 > -1 && y1 > -1 && x1 < w && y1 < h && x <= x1 && y <= y1;
    }


}
