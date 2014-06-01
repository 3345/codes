package ch1;

public class p1_6 {
    public static int [][] createMatrix (int row, int col, int min, int max) {
        int [][] matrix = new int[row][col];
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int x = (int) ((max-min)*Math.random());
                matrix[i][j] =  x;
            }
        }
        return matrix;
    }

    public static void printMatrix (int [][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static int [][] rotateMatrix (int [][] matrix) {
        int n = matrix.length;
        int layers = (int) Math.floor(matrix.length/2);
        for (int layer = 0; layer < layers; layer++) {
            for (int i = 0; i < n - layer - 1; i++) {
                int oldTop = matrix[layer][layer+i];
                //top = right
                matrix[layer][layer+i] = matrix[layer+i][n-1-layer];
                //right = bot
                matrix[layer+i][n-1-layer] = matrix[n-1-layer][n-1-layer-i];
                //bot = left
                matrix[n-1-layer][n-1-layer-i] = matrix[n-1-layer-i][layer];
                //left = oldTop
                matrix[n-1-layer-i][layer] = oldTop;
            }
        }
        return matrix;
    }

    public static void run (int n) {
        int [][] matrix = createMatrix(n, n, 0, 9);
        printMatrix(matrix);
        System.out.println("=================");
        printMatrix(rotateMatrix(matrix));
    }
}
