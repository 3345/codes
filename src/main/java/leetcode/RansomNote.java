package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fuyul on 12/27/2017.
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        if (ransomNote.length() == 0) {
            return true;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) {
                    map.remove(c);
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
