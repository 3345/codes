package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by fyl on 5/29/19.
 */
public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] a, int k) {
        int l = 0, r = 0, ans = 0, ones = 0;
        while (r < a.length) {
            if (a[r] == 1) {
                ones++;
            }
            if (ones + k >= r-l+1) {
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

    @Test
    public void t1() {
        int[] a = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        MaxConsecutiveOnesIII sol = new MaxConsecutiveOnesIII();
        assertEquals(6, sol.longestOnes(a, k));
    }

    @Test
    public void t2() {
        int[] a = new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        MaxConsecutiveOnesIII sol = new MaxConsecutiveOnesIII();
        assertEquals(10, sol.longestOnes(a, k));
    }
}
