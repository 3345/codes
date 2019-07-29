package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by fyl on 5/29/19.
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        char[] a = s.toCharArray();
        int[] map = new int[26];
        int l = 0, r = 0, ans = 0;

        while (r < a.length) {
            ++map[a[r]-'A'];
            int maxFrequency = 0;
            for (int i = 0; i < 26; i++) {
                maxFrequency = Math.max(maxFrequency, map[i]);
            }
            if (maxFrequency + k >= r-l+1) {
                ans = Math.max(ans, r-l+1);
            } else {
                --map[a[l]-'A'];
                l++;
            }
            r++;
        }

        return ans;
    }

    @Test
    public void t1() {
        LongestRepeatingCharacterReplacement sol = new LongestRepeatingCharacterReplacement();
        String s = "abccdbeddb".toUpperCase();
        int k = 3;
        assertEquals(6, sol.characterReplacement(s, k));
    }

    @Test
    public void t2() {
        LongestRepeatingCharacterReplacement sol = new LongestRepeatingCharacterReplacement();
        String s = "abab".toUpperCase();
        int k = 2;
        assertEquals(4, sol.characterReplacement(s, k));
    }

    @Test
    public void t3() {
        LongestRepeatingCharacterReplacement sol = new LongestRepeatingCharacterReplacement();
        String s = "AABABBA";
        int k = 1;
        assertEquals(4, sol.characterReplacement(s, k));
    }


    @Test
    public void t4() {
        LongestRepeatingCharacterReplacement sol = new LongestRepeatingCharacterReplacement();
        String s = "KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF";
        int k = 4;
        assertEquals(7, sol.characterReplacement(s, k));
    }

    @Test
    public void t5() {
        LongestRepeatingCharacterReplacement sol = new LongestRepeatingCharacterReplacement();
        String s = "abaa".toUpperCase();
        int k = 0;
        assertEquals(2, sol.characterReplacement(s, k));
    }

    @Test
    public void t6() {
        LongestRepeatingCharacterReplacement sol = new LongestRepeatingCharacterReplacement();
        String s = "KJRGKSKKOK";
        int k = 5;
        assertEquals(10, sol.characterReplacement(s, k));
    }
}
