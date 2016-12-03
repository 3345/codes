package leetcode;

/**
 * Created by fyl on 12/2/16.
 */
public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int h = matrix.length;
        int w = matrix[0].length;

        boolean topZero = false;
        boolean leftZero = false;

        for (int i = 0; i < w; i ++) {
            if (matrix[0][i] == 0) {
                topZero = true;
                break;
            }
        }

        for (int j = 0; j < h; j++) {
            if(matrix[j][0] == 0) {
                leftZero = true;
                break;
            }
        }

        //handle one liner

        if (h > 1 && w > 1) {
            for (int j = 1; j < h; j++) {
                for (int i = 1; i < w; i++) {
                    if (matrix[j][i] == 0) {
                        matrix[j][0] = 0;
                        matrix[0][i] = 0;
                    }
                }
            }

            for (int j = 1; j < h; j++) {
                for (int i = 1; i < w; i++) {
                    if (matrix[j][0] == 0 || matrix[0][i] == 0) {
                        matrix[j][i] = 0;
                    }
                }
            }
        }


        if (topZero) {
            for (int i = 0; i < w; i ++) {
                matrix[0][i] = 0;
            }
        }

        if (leftZero) {
            for (int j = 0; j< h; j ++) {
                matrix[j][0] = 0;
            }
        }
    }
}
