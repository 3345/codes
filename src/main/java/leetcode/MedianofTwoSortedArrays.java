package leetcode;

import org.junit.Test;

/**
 *  a1 a2 a3 a4
 *  b1 b2 b3 b4
 *
 *  k start from 1
 *
 *  scenario 1
 *  a [1,2,3,  4  ,5,6,7] 7
 *  b [1,1,  2  ,3,4] 5
 *
 *  k = 2
 *
 * 4 > 2;
 */
public class MedianofTwoSortedArrays {
    int[] a;
    int[] b;

    public double findMedianSortedArrays(int A[], int B[]) {
        this.a = A;
        this.b = B;

        if (a.length == 0) {
            return (b[(b.length - 1) / 2] + b[b.length / 2]) / 2.0;
        }

        if (b.length == 0) {
            return (a[(a.length - 1) / 2] + a[a.length / 2]) / 2.0;
        }

        int k = (a.length + b.length) / 2 + 1;

        int result = find(0, a.length - 1, 0, b.length - 1, k);

        if ((a.length + b.length) % 2 == 0) {
            return (result + find(0, a.length - 1, 0, b.length - 1, k - 1)) / 2.0;
        }

        return result;

    }

    public int find(int as, int ae,  int bs, int be, int k) {
        if (ae < as) {
            return b[bs + k - 1];
        }

        if (be < bs) {
            return a[as + k - 1];
        }

        int am = (ae + as) / 2;
        int bm = (be + bs) / 2;

        if (k == 1) {
            return Math.min(a[as], b[bs]);
        }

        if (k < am - as + 1 + bm - bs + 1) {
            if (a[am] < b[bm]) {
                return find(as, ae, bs, bm - 1, k);
            }

            if (b[bm] < a[am]) {
                return find(as, am - 1, bs, be, k);
            }

            return find(as, am, bs, bm, k);

        } else if (k > am - as + 1 + bm - bs + 1) {
            if (a[am] < b[bm]) {
                return find(am + 1, ae, bs, be, k - (am - as + 1));
            }

            if (b[bm] < a[am]) {
                return find(as, ae, bm + 1, be, k - (bm - bs + 1));
            }

            return find(am + 1, ae, bm + 1, be, k - (am - as + 1 + bm - bs + 1));

        } else {
            if (a[am] == b[bm]) {
                return a[am];
            }

            if (a[am] > b[bm]) {
                return find(as, am, bm + 1, be, k - (bm - bs + 1));

            } else {
                return find(am + 1, ae, bs, bm, k - (am - as + 1));
            }
        }
    }



    @Test
    public void t1() {
        // 0,1,1,3,4,5
        int[] a1 = {1,2}; // get 4th 1 1 2 2 3
        int[] a2 = {3,4,5};
        System.out.println(findMedianSortedArrays(a1, a2));
    }


}
