package leetcode;

import org.junit.Test;

/**
 * Created by fyl on 5/23/19.
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }

        int[] u = new int[n];
        int[] a2 = new int[n];
        int[] a3 = new int[n];
        int[] a5 = new int[n];
        u[0] = 1;
        int p=0, p2=0, p3=0, p5=0;

        while (p < n -1) {
            if (a2[p] == 0) {
                a2[p] = 2 * u[p];
                a3[p] = 3 * u[p];
                a5[p] = 5 * u[p];
            }


            if (a2[p2] <= a3[p3] && a2[p2] <= a5[p5]) {
                if (a2[p2] > u[p]) {
                    p++;
                    u[p] = a2[p2];
                }
                p2++;
                continue;
            }
            if (a3[p3] <= a5[p5]) {
                if (a3[p3] > u[p]) {
                    p++;
                    u[p] = a3[p3];
                }
                p3++;
                continue;
            }
            if (a5[p5] > u[p]) {
                p++;
                u[p] = a5[p5];
            }
            p5++;
            continue;
        }
        return u[n-1];
    }

    @Test
    public void test() {
        UglyNumberII sol = new UglyNumberII();
        int i = sol.nthUglyNumber(10);
        System.out.println(i);
    }
}
