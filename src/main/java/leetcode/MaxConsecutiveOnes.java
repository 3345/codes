package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by fyl on 5/29/19.
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] a) {
        int ones = 0, ans = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                ones++;
            } else {
                ans = Math.max(ans, ones);
                ones = 0;
            }
        }
        ans = Math.max(ans, ones);
        return ans;
    }

    @Test
    public void t1() {
        int[] a = new int[]{1,0,1,1,0,1};
        MaxConsecutiveOnes sol = new MaxConsecutiveOnes();
        assertEquals(2, sol.findMaxConsecutiveOnes(a));
    }


}
