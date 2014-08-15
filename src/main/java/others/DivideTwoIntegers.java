package others;

import org.junit.Test;

/**
 Divide two integers without using multiplication, division and mod operator.
 */

public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        return (int)divideL(dividend,divisor);
    }

    public static long divideL(long dividend,long divisor) {
        if (divisor == 1) return dividend;
        if (divisor < 0) return -divideL(dividend, -divisor);
        if (dividend < 0) return -divideL(-dividend, divisor);
        if (divisor > dividend) return 0;
        if (divisor == 0) return Integer.MAX_VALUE;

        long d = divisor;
        long bitcnt = 1;
        long ans = 0;

        while (d < dividend) {
            d <<= 1;
            bitcnt <<= 1;
        }

        while (d >= divisor) {
            while (dividend >= d) {
                dividend -= d;
                ans += bitcnt;
            }

            d >>= 1;
            bitcnt >>= 1;
        }

        return ans;
    }

    @Test
    public void test() {
        System.out.println(divide(5,2));
    }

}
