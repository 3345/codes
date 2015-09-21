package leetcode;

import org.junit.Test;

public class Pow {
    public double pow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        if (n > 0) {
            int re = n % 2;
            double partial = pow(x, n / 2);
            double result = partial * partial;
            return  result * pow(x, re);
        }

        return 1.0 / pow(x, -n);
    }

    @Test
    public void test() {
        System.out.println(pow(1, 2147483647));
    }
}
