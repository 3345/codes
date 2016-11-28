package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fyl on 11/27/16.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        char[] sa = s.toCharArray();

        for (int i = 0; i < sa.length; i++) {
            char c = sa[i];
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        char[] ta = t.toCharArray();

        for (int i = 0; i < ta.length; i++) {
            char c = ta[i];

            if(!map.containsKey(c)) {
                return false;
            } else {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
            }
        }

        if (map.size() != 0) {
            return false;
        }

        return true;
    }
}
