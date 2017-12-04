package lintcode;

import junit.framework.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by fyl on 12/3/17.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        //forward pointer
        int head = 0;
        //tailing pointer
        int tail = 0;

        int max = 0;

        Set<Character> set = new HashSet<>();

        while (head < s.length()) {
            if(!set.contains(s.charAt(head))) {
                set.add(s.charAt(head));
                max = Math.max(max, set.size());
            } else {
                while(tail < head) {
                    if (s.charAt(head) == s.charAt(tail)) {
                        tail++;
                        break;
                    } else {
                        set.remove(s.charAt(tail));
                        tail++;
                    }
                }
            }
            head++;
        }

        return max;
    }

    @Test
    public void test() {
        String s = "an++--viaj";
        LongestSubstringWithoutRepeatingCharacters sol = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(sol.lengthOfLongestSubstring(s));
    }

}
