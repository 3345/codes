package leetcode;

import org.junit.Test;

public class UglyNumberII {
    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        int[] u = new int[n], tw = new int[n], th = new int[n], f = new int[n];
        u[0] = 1;
        int p=0, p2=0, p3=0, p5=0;
        while (p<n) {
            tw[p] = 2*u[p];
            th[p] = 3*u[p];
            f[p] = 5*u[p];

            if (tw[p2] <= th[p3] && tw[p2] <= f[p5]) {

            }
        }
        return u[n];
    }


    @Test
    public void test() {
        UglyNumberII sol = new UglyNumberII();
        int i = sol.nthUglyNumber(11);
        System.out.println(i);
    }
}
