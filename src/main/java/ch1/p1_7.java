package ch1;

import java.util.ArrayList;
import java.util.List;

public class p1_7 {

    public static int[][] setZeros(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> rowOfZero = new ArrayList<Integer>();
        List<Integer> colOfZero = new ArrayList<Integer>();
        for (int i = 0; i < row; i++ ) {
            for (int j = 0; j < col; j++ ) {
                if (matrix[i][j] == 0) {
                    rowOfZero.add(i);
                    break;
                }
            }
        }
        for (int j = 0; j < col; j++ ) {
            for (int i = 0; i < row; i++ ) {
                if (matrix[i][j] == 0) {
                    colOfZero.add(j);
                    break;
                }
            }
        }

        for (int i:rowOfZero) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = 0;
            }
        }

        for (int j:colOfZero) {
            for (int i = 0; i < row; i++) {
                matrix[i][j] = 0;
            }
        }

        return matrix;
    }

    public static void run (int row, int col) {
        int [][] matrix = p1_6.createMatrix(row, col, 0, 9);
        p1_6.printMatrix(matrix);
        System.out.println("================================");
        matrix = setZeros(matrix);
        p1_6.printMatrix(matrix);
    }
}
