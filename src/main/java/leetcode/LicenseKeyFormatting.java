package leetcode;

import org.junit.Test;

public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String s, int k) {
        int cur = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i > -1; i--) {
            char c = s.charAt(i);
            if (c == '-') continue;
            if (cur >= k) {
                sb.insert(0, '-');
                cur = 1;
            } else {
                cur++;
            }
            sb.insert(0, Character.toUpperCase(c));
        }
        return sb.toString();
    }

    @Test
    public void t() {
        String s = "2-5g-3-J";
        int k = 2;
        licenseKeyFormatting(s,k);
    }
}
