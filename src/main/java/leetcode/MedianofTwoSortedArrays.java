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
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1.length <= nums2.length ? nums1 : nums2;
        int[] B = nums1.length <= nums2.length ? nums2 : nums1;
        int m = A.length; int n = B.length;
        int start = 0; int end = m;
        int i; int j;

        while (start <= end) {
            i = (start + end) / 2;
            j = (m + n + 1 - 2*i)/2;

            if (i > 0 && A[i-1] > B[j]) {
                end = i-1;
                continue;
            }

            if (i < m && B[j-1] > A[i]) {
                start = i+1;
                continue;
            }

            int leftMax;
            int rightMin;
            if (i == 0) {
                leftMax = B[j-1];
            } else if (j == 0) {
                leftMax = A[i-1];
            } else {
                leftMax = Math.max(A[i-1], B[j-1]);
            }

            if (i == m) {
                rightMin = B[j];
            } else if (j == n) {
                rightMin = A[i];
            } else {
                rightMin = Math.min(A[i], B[j]);
            }

            if ((m+n)%2 == 1) {
                return leftMax;
            } else {
                return (double) (leftMax + rightMin)/2;
            }
        }

        return 0;

    }



    @Test
    public void t1() {
        // 0,1,1,3,4,5
        int[] a1 = {}; // get 4th 1 1 2 2 3
        int[] a2 = {1};
        System.out.println(findMedianSortedArrays(a1, a2));
    }


}
