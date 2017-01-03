package leetcode;

import org.junit.Test;

/**
 * Created by fyl on 1/2/17.
 */
public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }

        if (s.length() == t.length()) {
            int diff = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    diff++;
                }

                if (diff > 1) {
                    return false;
                }
            }

            return  diff == 1;
        } else {
            String lo;
            String sh;

            int diff = 0;
            int lop = 0;
            int shp = 0;

            if (s.length() > t.length()) {
                lo = s;
                sh = t;
            } else {
                lo = t;
                sh = s;
            }

            while (lop < lo.length() && shp < sh.length()) {
                if (lo.charAt(lop) != sh.charAt(shp)) {
                    if (diff > 0) {
                        return false;
                    }

                    diff ++;
                    lop ++;
                } else {
                    lop++;
                    shp++;
                }
            }

            return true;
        }
    }

    @Test
    public void t() {
        isOneEditDistance("ab", "acd");
    }
}
