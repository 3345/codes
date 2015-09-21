package leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }

        if (strs.length == 0) {
            return "";
        }

        char[] first = strs[0].toCharArray();

        List<Character> chars = new ArrayList<>();

        for (char c : first) {
            chars.add(c);
        }

        for (int i = 1; i < strs.length; i ++) {
            String s = strs[i];

            for (int j = 0; j < chars.size(); j ++) {
                if (j >= s.length()) {
                    chars.add(j, null);
                    break;
                }

                if (chars.get(j) == null) {
                    break;
                }

                if (s.charAt(j) != chars.get(j)) {
                    chars.add(j, null);
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chars.size(); i ++ ) {
            if (chars.get(i) != null) {
                sb.append(chars.get(i));
            } else {
                break;
            }
        }

        return sb.toString();
    }

    @Test
    public void test() {
        String[] ss = {"abcd", "abc", "abc", "abcdefadsfa"};

        String as = new LongestCommonPrefix().longestCommonPrefix(ss);

        System.out.println(as);
    }
}
