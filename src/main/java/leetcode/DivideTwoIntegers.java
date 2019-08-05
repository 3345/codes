package leetcode;

import org.junit.Test;

/**
 Divide two integers without using multiplication, division and mod operator.
 */

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 1) return dividend;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (divisor == Integer.MIN_VALUE) return 0;

        // a/b
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);

        int remain = a;
        int q = 0;
        while (remain >= b) {
            int cur = b;
            int curq = 0;
            while (cur <= remain && cur > 0) {
                if (curq == 0) {
                    curq = 1;
                } else {
                    curq = curq+curq;
                }
                cur = cur << 1;
            }
            q += curq;
            remain -= cur >>> 1;
        }
        if (dividend < 0 && divisor < 0 || dividend > 0 && divisor > 0) {
            return q;
        } else {
            return 0-q;
        }
    }

    @Test
    public void test() {
        System.out.println(divide(2147483647,
                2));
    }

}
