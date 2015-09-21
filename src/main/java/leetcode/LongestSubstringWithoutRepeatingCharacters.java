package leetcode;

import org.junit.Test;

import java.util.*;

/**
 Given a string, find the length of the longest substring without repeating characters.
 For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        Arrays.fill(map, -1);
        int start = 0, max = 0;
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (map[c] != -1) {
                max = Math.max(max, i - start);
                start = map[c] + 1;
                for (int j = 0; j < map.length; j ++) {
                    if (map[j] < start)
                        map[j] = -1;
                }
            }
            map[c] = i;
        }
        return Math.max(max, s.length() - start);
    }

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("qopubjguxhxdipfzwswybgfylqvjzhar"));

    }
}
