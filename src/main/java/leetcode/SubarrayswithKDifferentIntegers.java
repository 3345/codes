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

//    private int atMost(int[] A, int K) {
//        int i = 0, j = 0;
//        int total = 0;
//        int distinct = 0;   // count of distinct numbers in the window.
//        Map<Integer, Integer> counter = new HashMap<>();
//        while (j < A.length) {
//            if (counter.getOrDefault(A[j], 0) == 0) {
//                distinct++;
//            }
//            counter.put(A[j], 1 + counter.getOrDefault(A[j], 0));
//            j++;
//            while (i < j && distinct > K) {  // shrink the left boundary of window.
//                counter.put(A[i], counter.get(A[i]) - 1);
//                if (counter.get(A[i]) == 0) {
//                    distinct--;
//                }
//                i++;
//            }
//
//            total += j - i;
//        }
//
//        return total;
//    }

    @Test
    public void test() {
        int[] a = new int[]{1, 2, 1, 2, 3};
        int k = 2;
        SubarrayswithKDifferentIntegers sol = new SubarrayswithKDifferentIntegers();
        int ans = sol.atMost(a, k);
        System.out.print(ans);
    }
}
