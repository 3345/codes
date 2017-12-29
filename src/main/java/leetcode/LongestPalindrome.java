package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by fyl on 12/28/17.
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int count = 0;

        for (Character c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                count += 2;
            } else {
                set.add(c);
            }
        }

        if (!set.isEmpty()) {
            count ++;
        }

        return count;
    }

    @Test
    public void test() {
        String s = "abccccdd";
        longestPalindrome(s);
    }
}
