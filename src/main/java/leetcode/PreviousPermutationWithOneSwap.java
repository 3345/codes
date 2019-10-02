package leetcode;

import org.junit.Test;

/**
 * Created by fyl on 7/28/19.
 */
public class PreviousPermutationWithOneSwap {
    public int[] prevPermOpt1(int[] a) {
        if (a.length < 2) {
            return a;
        }
        int t = -1;
        for (int i = a.length -1; i >  0; i--) {
            if (a[i] < a[i-1]) {
                t = i;
                break;
            }
        }
        if (t == -1) {
            return a;
        }

        int t1 = -1;
        int t2 = -1;
        int diff1 = Integer.MAX_VALUE;
        int diff2 = Integer.MAX_VALUE;

        for (int i = t; i < a.length; i++) {
            int d1 = a[t] - a[i];
            if (d1 > 0 && d1 < diff1) {
                diff1 = d1;
                t1 = i;
            }
            int d2 = a[t-1] - a[i];
            if (d2 > 0 && d2 < diff2) {
                diff2 = d2;
                t2 = i;
            }
        }
        if (t1 != -1) {
            swap(a, t, t1);
        } else if (t2 != -1) {
            swap(a, t-1, t2);
        }
        return a;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    @Test
    public void test() {
        int[] a = new int[]{3,1,1,3};
        prevPermOpt1(a);
    }
}
