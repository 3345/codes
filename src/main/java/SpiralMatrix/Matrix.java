package SpiralMatrix;

public class Matrix {
    private String[][] matrix;
    private int n;
    private int m;

    public Matrix(int n, int m) {
        if (n > 0 || m > 0) {
            this.n = n;
            this.m = m;
        }
    }

    public void populate() {
        String[][] matrix = new String[m][n];

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                //choose a char between a-z randomly
                char c = (char) ('a' + (int) Math.ceil(Math.random()*25));
                matrix[j][i] = c + "";
            }
        }

        this.matrix = matrix;
    }

    public void populate(String input) {
        String[][] matrix = new String[m][n];
        String[] rows = input.split("\n");

        for (int j = 0; j < m; j++) {
            String[] row = rows[j].split(" ");

            for (int i = 0; i < n; i++) {
                matrix[j][i] = row[i];
            }
        }

        this.matrix = matrix;
    }

    public void print() {
        if (matrix == null)
            return;
        for (int j = 0; j < m; j ++) {
            for (int i = 0; i < n; i ++) {
                System.out.print(matrix[j][i] + ' ');
            }
            System.out.println();
        }
    }

    public void printSpiral() {
        if (matrix == null)
            return;

        int count = n * m, layer = 0;

        while (count > 0) {
            // top move right
            for (int i = layer; count > 0 && i <= n - layer - 1; i++) {
                System.out.print(matrix[layer][i] + ' ');
                count --;
            }

            // right move down
            for (int i = layer + 1; count > 0 && i < m - layer - 1; i++) {
                System.out.print(matrix[i][n - layer - 1] + ' ');
                count --;
            }

            // bottom move left
            for (int i = n - layer - 1; count > 0 && i >= layer; i--) {
                System.out.print(matrix[m - layer - 1][i] + ' ');
                count --;
            }

            // left move up
            for (int i = m - layer - 2; count > 0 && i > layer; i--) {
                System.out.print(matrix[i][layer] + ' ');
                count --;
            }

            layer ++;
        }

        System.out.println();
    }
}
