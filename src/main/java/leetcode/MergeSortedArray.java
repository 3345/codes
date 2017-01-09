package leetcode;

/**
 * Created by yulai on 1/9/17.
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || n == 0) {
            return;
        }

        int p = m + n - 1;
        int p1 = m - 1;
        int p2 = n - 1;

        while (p1 > -1 && p2 > -1) {
            nums1[p] = Math.max(nums1[p1], nums2[p2]);
            if (nums1[p] == nums1[p1]) {
                p1--;
            } else {
                p2--;
            }
            p--;
        }

        while (p1 > -1) {
            nums1[p] = nums1[p1];
            p1--;
            p--;
        }

        while (p2 > -1) {
            nums1[p] = nums1[p2];
            p2--;
            p--;
        }
    }
}
