package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fyl on 11/26/16.
 */
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        if (s == null) {
            return -1;
        }
        char[] a = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            char c = a[i];
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < a.length; i ++) {
            if (map.get(a[i]) == 1) {
                return i;
            }
        }
        return  -1;
    }
}
