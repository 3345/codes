package leetcode;

import org.junit.Test;

/**
 * Created by fyl on 12/28/17.
 */
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        char[] a = s.toCharArray();
        int len = s.length();

        int[][] m = new int[len][len];

        for (int i = 0; i < len; i++) {
            m[i][i] = 1;
        }

        for (int l = 1; l < len; l++) {
            for (int k  = 0; k < len - l; k++) {
                int i = k;
                int j = k + l;
                if (a[j] == a[i]) {
                    m[j][i] = Math.max(m[j-1][i], m[j-1][i+1] + 2);
                } else {
                    m[j][i] = Math.max(m[j-1][i], m[j][i+1]);
                }
            }
        }

        return m[len - 1][0];
    }

    @Test
    public void test() {
        String s = "cbbd";
        longestPalindromeSubseq(s);
    }
}
