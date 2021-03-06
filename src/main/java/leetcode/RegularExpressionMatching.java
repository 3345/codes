package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 Implement regular expression matching with support for '.' and '*'.

 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "a*") → true
 isMatch("aa", ".*") → true
 isMatch("ab", ".*") → true
 isMatch("aab", "c*a*b") → true
 */

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
    }

    public boolean isMatch(String s, String p, int si, int pi) {
        if (si == s.length()) {
            for (int i = pi; i < p.length(); i += 2) {
                if (i == p.length() - 1)
                    return false;
                if (p.charAt(i + 1) != '*')
                    return false;
            }
            return true;
        }

        if (pi == p.length())
            return si == s.length();

        char sc = s.charAt(si);
        char pc = p.charAt(pi);

        if (pi == p.length() - 1)
            return si == s.length() - 1 && (sc == pc || pc == '.');
        if ((sc == pc || pc == '.') && p.charAt(pi + 1) != '*')
            return isMatch(s, p, si + 1, pi + 1);
        if (sc != pc && pc != '.' && p.charAt(pi + 1) != '*')
            return false;
        if (p.charAt(pi + 1) == '*' && pc != '.' && pc != sc)
            return isMatch(s, p, si, pi + 2);
        if (p.charAt(pi + 1) == '*' && (pc == sc || pc == '.')) {
            for (int i = si; i < s.length(); i ++) {
                sc = s.charAt(i);
                if (sc == pc || pc == '.') {
                    if (isMatch(s, p, i, pi + 2))
                        return true;
                } else {
                    return isMatch(s, p, i, pi + 2);
                }
            }

        }
        //s is exhausted
        return isMatch(s, p, s.length(), pi + 2);
    }

    @Test
    public void test() {
        assertFalse(isMatch("aa", "a"));
        assertTrue(isMatch("aa", "aa"));
        assertFalse(isMatch("aaa", "aa"));
        assertTrue(isMatch("aa", ".*"));
        assertTrue(isMatch("aab", "c*a*b"));
        assertFalse(isMatch("aaa", "ab*a"));
        assertTrue(isMatch("a", "ab*"));
        assertFalse(isMatch("ab", ".*c"));
        assertTrue(isMatch("aa", "a*"));

    }
}
