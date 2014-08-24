package SpiralMatrix;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);

        int n, m;

        while (true) {
            System.out.println("enter width and height of the matrix, separated by spaces. enter q! to quit");
            String input = userInputScanner.nextLine();

            if ("q!".equals(input))
                return;

            try {
                String[] a = input.split("\\s+");

                if (a.length != 2)
                    throw new Exception();

                int width = Integer.parseInt(a[0]);
                int height = Integer.parseInt(a[1]);

                if (width > 0 && height > 0) {
                    n = width;
                    m = height;
                    break;
                }
                throw new Exception();
            } catch (Exception e) {
                System.out.println("invalid input, must be two integer greater than 0, separated by spaces" + "\n");
            }
        }

        Matrix matrix = new Matrix(n, m);

        while (true) {
            System.out.println("do you want to populate the matrix automatically? enter y or n. enter q! to quit");
            String input = userInputScanner.nextLine();

            if ("q!".equals(input))
                return;

            if ("y".equals(input)) {
               matrix.populate();
               break;
            }

            if ("n".equals(input)) {
                StringBuilder sb = new StringBuilder();
                int height = m;

                while (height > 0) {
                    System.out.println(String.format("enter %s elements separated by spaces as %sth row of the matrix. enter q! to quit", n, m - height + 1));
                    input = userInputScanner.nextLine();

                    if ("q!".equals(input))
                        return;

                    if (input.split("\\s+").length == n) {
                        sb.append(input + "\n");
                        height --;
                    } else
                        System.out.println(String.format("invalid input, must have exactly %s elements \n", n));
                }

                matrix.populate(sb.toString());
                break;
            }
        }

        System.out.println("\nmatrix:");
        matrix.print();
        System.out.println("\n" + "clockwise inward spiral traversal:");
        matrix.printSpiral();
    }

}
