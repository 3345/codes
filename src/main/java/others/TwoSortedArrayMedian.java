package others;

import org.junit.Test;

/**
 *  a1 a2 a3 a4
 *  b1 b2 b3 b4
 */
public class TwoSortedArrayMedian {
    public int find(int[] a1, int start1, int end1, int[] a2, int start2, int end2, int k) {
        int m1 = (end1 + start1 + 1)/2;
        int m2 = (end2 + start2 + 1)/2;

        int n1 = a1[m1];
        int n2 = a2[m2];
        // a1, a2, m1, a4, a5
        //     b1, m2, b3

        if (n1 < n2) {
            int sizeOfUpperLeft = a1.length/2;
            if (sizeOfUpperLeft == k - 1)
                return n1;
            if (sizeOfUpperLeft >= k) {
                return find(a1, start1, m1, a2, start2, end2, k);
            }
            if (sizeOfUpperLeft < k) {
                return find(a1, m1, end1, a2, start2, end2, k - (m1 - start1 +1));
            }
        }

        if (n1 > n2) {
            int sizeOfLowerLeft = a2.length/2;
            if (sizeOfLowerLeft == k - 1)
                return n2;
            if (sizeOfLowerLeft >= k) {
                return find(a1, start1, end1, a2, start2, m2, k);
            }
            if (sizeOfLowerLeft < k) {
                return find(a1, start1, end1, a2, m2, end2, k - (m2 - start2 +1));
            }
        }

        return n1;
    }



    @Test
    public void t1() {
        // 0,1,1,3,4,5
        int[] a1 = {0,1,4,5};
        int[] a2 = {1,3};
        System.out.println(find(a1, 0, 3, a2, 0, 1, 4));
    }

}
