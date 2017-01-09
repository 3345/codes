package leetcode;

import org.junit.Test;

/**
 * Created by yulai on 1/9/17.
 */
public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }

        if (needle.length() == 0) {
            return 0;
        }

        if (haystack.equals(needle)) {
            return 0;
        }

        int i = 0;

        while (i <= haystack.length() - needle.length()) {

            for (int ni = 0; ni < needle.length(); ni++) {
                if (haystack.charAt(i + ni) != needle.charAt(ni)) {
                    break;
                } else if (ni == needle.length() - 1) {
                    return i;
                }

            }

            i++;
        }

        return -1;
    }

    @Test
    public void t() {
        strStr("mississippi", "pi");
    }
}
