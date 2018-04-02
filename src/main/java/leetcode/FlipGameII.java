package leetcode;

import org.junit.Test;

/**
 * Created by fyl on 4/1/18.
 */
public class FlipGameII {
    public boolean canWin(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }

        return helper(s.toCharArray());
    }

    public boolean helper(char[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == '+' && arr[i+1] == '+') {
                arr[i] = '-'; arr[i+1] = '-';
                boolean oppoWin = helper(arr);
                arr[i] = '+'; arr[i+1] = '+';
                if (!oppoWin) {
                    return true;
                }
            }
        }

        return false;
    }

    @Test
    public void test() {
        String s = "++++";
        canWin(s);
    }
}
