package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fyl on 12/4/16.
 */
public class CountPrimes {
    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }

        if (n == 3) {
            return 1;
        }

        int[] a = new int[n];

        int p = 2;

        while (p < n) {
            if (a[p] == 1) {
                p++;
                continue;
            }

            for (int i = 2; p*i < n; i ++) {
                a[p*i] = 1;
            }

            p++;
        }

        int count = 0;

        for (int i = 2 ; i < a.length; i ++) {
            if (a[i] == 0) {
                count++;
            }
        }

        return count;

    }

    @Test
    public void t() {
        System.out.print(countPrimes(99999));
    }
}
