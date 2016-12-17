package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fyl on 12/16/16.
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || s.length() < 2) {
            return true;
        }

        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (mapS.containsKey(s.charAt(i))) {
                if (mapT.containsKey(t.charAt(i))) {
                    if (mapS.get(s.charAt(i)) != t.charAt(i) || mapT.get(t.charAt(i))!= s.charAt(i)) {
                        return false;
                    }
                } else {
                    return false;
                }

            } else {
                if (mapT.containsKey(t.charAt(i))) {
                    return false;
                } else {
                    mapS.put(s.charAt(i), t.charAt(i));
                    mapT.put(t.charAt(i), s.charAt(i));
                }
            }
        }

        return true;
    }
}
