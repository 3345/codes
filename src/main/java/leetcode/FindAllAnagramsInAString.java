package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * Created by yulai on 11/28/16.
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        if (s == null || p == null || s.length() < p.length()) {
            return ans;
        }

        char[] pa = p.toCharArray();
        char[] sa = s.toCharArray();


        Map<Character, Integer> pMap = new HashMap<>();

        for (int i = 0; i < pa.length; i++) {
            char c = pa[i];
            if (pMap.containsKey(c)) {
                pMap.put(c, pMap.get(c) + 1);
            } else {
                pMap.put(c, 1);
            }
        }

        Map<Character, Integer> sMap = new HashMap<>();

        for (int i = 0; i < pa.length; i++) {
            char c = sa[i];
            if (sMap.containsKey(c)) {
                sMap.put(c, sMap.get(c) + 1);
            } else {
                sMap.put(c, 1);
            }
        }

        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            if (i > 0) {
                int num =  sMap.get(sa[i - 1]) - 1;
                if (num == 0) {
                    sMap.remove(sa[i - 1]);
                } else {
                    sMap.put(sa[i-1], num);
                }

                char c = sa[i + p.length() - 1];
                if (sMap.containsKey(c)) {
                    sMap.put(c, sMap.get(c) + 1);
                } else {
                    sMap.put(c, 1);
                }
            }

            if (compare(pMap, sMap)) {
                ans.add(i);
            }
        }

        return ans;
    }

    private boolean compare(Map<Character, Integer> m1, Map<Character, Integer> m2) {
        if (m1.size() != m2.size()) {
            return false;
        }

        for (Map.Entry<Character, Integer> entry : m1.entrySet()) {
            Character key = entry.getKey();
            Integer val = entry.getValue();
            if (m2.containsKey(key) && m2.get(key).equals(val)) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }


    @Test
    public void t0() {
        String s = "cbaebabacd";
        String p = "abc";

        findAnagrams(s, p);
    }
}
