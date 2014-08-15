package others;

import org.junit.Test;

/**
 A message containing letters from A-Z is being encoded to numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Given an encoded message containing digits, determine the total number of ways to decode it.

 For example,
 Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

 The number of ways decoding "12" is 2.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0')
            return 0;

        int [] ways = new int[s.length()];
        ways[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            int num = Integer.parseInt(s.substring(i - 1, i + 1));
            if (s.charAt(i) == '0') {
                if (num > 26 || num <= 0)
                    return 0;
                if (i - 2 >= 0)
                    ways[i] = ways[i - 2];
                else
                    ways[i] = 1;
            } else {
                ways[i] = ways[i - 1];
                if (num > 10 && num <= 26) {
                    if (i - 2 >= 0)
                        ways[i] = ways[i] + ways[i - 2];
                    else
                        ways[i] = ways[i] + 1;
                }
            }
        }
        return ways[ways.length - 1];
    }

    @Test
    public void test() {
        System.out.println(numDecodings("110"));
    }
}
