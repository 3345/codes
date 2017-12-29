package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by fyl on 12/28/17.
 */
public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        Set<Character> set = new HashSet<>();
        for (Character c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.size() < 2;
    }
}
