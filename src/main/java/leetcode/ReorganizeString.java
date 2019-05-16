package leetcode;

import org.junit.Test;

import java.util.Arrays;


/**
 * Created by fyl on 5/4/19.
 */
public class ReorganizeString {
    public String reorganizeString(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }
        int[] arr = new int[256];
        int max = 0;
        int len = S.length();
        char most = 0;
        char[] cArr = S.toCharArray();
        for (char c : cArr) {
            arr[c] = arr[c] + 1;
            max = Math.max(max, arr[c]);
            if (max == arr[c]) {
                most = c;
            }
        }

        if (max > (len + 1) / 2) {
            return "";
        }

        Arrays.sort(cArr);
        char[] rArr = new char[len];

        for (int i = 0; i <arr[most]; i++) {
            rArr[2*i] = most;
        }

        int i = 0;
        for (int j = 2*arr[most]; j < len; j += 2) {
            while (cArr[i] == most) {
                i ++;
            }
            rArr[j] = cArr[i];
            i++;

        }
        for (int j = 1; j < len; j += 2) {
            while (cArr[i] == most) {
                i ++;
            }
            rArr[j] = cArr[i];
            i++;
        }


        return new String(rArr);
    }

    @Test
    public void t() {
        ReorganizeString sol = new ReorganizeString();
        sol.reorganizeString("zifrfbctby");
    }
}


