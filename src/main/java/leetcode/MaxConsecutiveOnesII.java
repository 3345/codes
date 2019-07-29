package leetcode;

/**
 * Created by fyl on 5/29/19.
 */
public class MaxConsecutiveOnesII {
    public int findMaxConsecutiveOnes(int[] a) {
        int l = 0, r = 0, ans = 0, ones = 0;
        while (r < a.length) {
            if (a[r] == 1) {
                ones++;
            }
            if (ones + 1 >= r-l+1) {
                ans = Math.max(ans, r-l+1);
            } else {
                if (a[l] == 1) {
                    ones--;
                }
                l++;
            }
            r++;
        }
        return ans;

    }
}
