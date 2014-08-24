package SpiralMatrix;

import org.junit.Test;

public class SpiralMatrixTest {

    @Test
    public void OK_toHaveOneRowMatrix() {
        createAndPrintMatrix(3, 1);
    }

    @Test
    public void OK_toHaveOneColMatrix() {
        createAndPrintMatrix(1, 3);
    }

    @Test
    public void normalMatrix() {
        createAndPrintMatrix(5, 3);
    }

    @Test
    public void willNotCrash_whenMatrixHaveInvalidDimension() {
        createAndPrintMatrix(-1 , -1);
        createAndPrintMatrix(0, 10);
        createAndPrintMatrix(1, -1);
    }

    private void createAndPrintMatrix(int n, int m) {
        Matrix matrix = new Matrix(n, m);
        matrix.populate();
        matrix.print();
        matrix.printSpiral();
        System.out.println();
    }
}
