package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by yulai on 12/9/16.
 */
public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }

        char[] a = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, len = 0;

        while (l < a.length && r < a.length) {
            if (map.size() <= k) {
                map.put(a[r], map.getOrDefault(a[r], 0) + 1);
                if (map.size() <= k) {
                    len = Math.max(len, r - l + 1);
                }
                r++;
            } else {
                if (map.get(a[l]) == 1) {
                    map.remove(a[l]);
                } else {
                    map.put(a[l], map.get(a[l]) - 1);
                }
                l++;
            }
        }

        return len;
    }

    @Test
    public void test() {
        String s = "eceba";
        int k = 2;
        LongestSubstringWithAtMostKDistinctCharacters sol = new LongestSubstringWithAtMostKDistinctCharacters();
        int ans = sol.lengthOfLongestSubstringKDistinct(s, k);
        System.out.print(ans);
    }
}
