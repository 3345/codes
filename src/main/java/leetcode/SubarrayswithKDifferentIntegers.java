package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fyl on 5/28/19.
 */
public class SubarrayswithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] a, int k) {
        return this.atMost(a, k) - this.atMost(a, k - 1);
    }

    private int atMost(int[] a, int k) {
        if (a.length == 0) {
            return 0;
        }

        int l = 0, r = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (r < a.length) {
            if (map.size() <= k) {
                map.put(a[r], map.getOrDefault(a[r], 0) + 1);
                r++;
            }
            while (map.size() > k) {
                map.put(a[l], map.getOrDefault(a[l], 0) - 1);
                if (map.get(a[l]) < 1) map.remove(a[l]);
                l++;
            }
            res += r - l;
        }
        return res;
    }

    @Test
    public void test() {
        int[] a = new int[]{1, 2, 1, 2, 3};
        int k = 2;
        SubarrayswithKDifferentIntegers sol = new SubarrayswithKDifferentIntegers();
        int ans = sol.atMost(a, k);
        System.out.print(ans);
    }
}
