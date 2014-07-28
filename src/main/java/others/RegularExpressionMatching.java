package others;

import org.junit.Test;

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
        if (si == s.length())
            return pi == p.length();
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
            return isMatch(s, p, si + 1, pi + 2);
        if (p.charAt(pi + 1) == '*' && (pc == sc || pc == '.')) {
            for (int i = si; i < s.length(); i ++) {
                sc = s.charAt(i);
                if (sc == pc || pc == '.') {
                    if (isMatch(s, p, i + 1, pi + 2))
                        return true;
                } else {
                    return isMatch(s, p, i, pi + 2);
                }
            }

        }
        return false;
    }

    @Test
    public void test() {
//        System.out.println(isMatch("aa", "a"));
//        System.out.println(isMatch("aa", "aa"));
//        System.out.println(isMatch("aaa", "aa"));
//        System.out.println(isMatch("aa", "a*"));
//        System.out.println(isMatch("aa", ".*"));
//        System.out.println(isMatch("ab", ".*"));
//        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("abcbcd", "a.*c.*d"));
    }
}
