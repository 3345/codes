package leetcode;

import org.junit.Test;

import java.util.*;

/**
 * Created by fyl on 5/23/19.
 */
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) {
            return 1;
        }

        long u = 1;
        int count = 1;
        int k = primes.length;
        long[][] list = new long[k][n];
        int[] p = new int[k];
        for (int i = 0; i<k; i++) {
            list[i][0] = (long)primes[i];
        }
        while (count < n) {
            long min = (long)Integer.MAX_VALUE;

            for (int i = 0; i < k; i++) {
                min = Math.min(min, list[i][p[i]]);
            }
            for (int i = 0; i < k; i++) {
                if (min == list[i][p[i]]) {
                    p[i]++;
                }
            }
            if (min > u) {
                u = min;
                for (int j = 0; j < k; j++) {
                    list[j][count]= primes[j]*u;
                }
                count++;
            }

        }
        return (int) u;
    }


    @Test
    public void test() {
        int n = 12;
        int[] primes = new int[]{2, 7, 13, 19};
        SuperUglyNumber sol = new SuperUglyNumber();
        int i = sol.nthSuperUglyNumber(n, primes);
        System.out.print(i);
    }
}
