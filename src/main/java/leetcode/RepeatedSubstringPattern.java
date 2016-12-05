package leetcode;

/**
 * Created by fyl on 12/4/16.
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String str) {
        if (str == null || str.length() < 2) {
            return false;
        }

        char[] arr = str.toCharArray();


        for (int len = 1; len <= str.length() / 2; len ++) {
            if (str.length() %  len == 0) {
                //repetition
                int n = str.length() / len;
                boolean ok = true;

                for (int i = 0; i < len; i++) {
                    boolean toBreak = false;
                    char c = arr[i];
                    for (int j = 1; j < n; j ++) {
                        if (arr[i + j * len] != c) {
                            toBreak = true;
                            break;
                        }
                    }

                    if (toBreak) {
                        ok = false;
                        break;
                    }

                }

                if (ok) {
                    return true;
                }
            }
        }

        return false;
    }
}
