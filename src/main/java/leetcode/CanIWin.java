package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fyl on 12/30/16.
 */
public class CanIWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }

        int[] arr = new int[maxChoosableInteger];

        return solve(arr, desiredTotal, new HashMap<Integer, Boolean>());
    }

    public boolean solve(int[] used, int total, Map<Integer, Boolean> mem) {
        int en = encode(used);
        if (mem.containsKey(en)) {
            return mem.get(en);
        }

        for(int i  = 0; i < used.length; i++) {
            if (used[i] == 0) {
                if (i + 1 >= total) {
                    mem.put(en, true);
                    return true;
                } else {
                    used[i] = 1;
                    boolean canOpponentWin = solve(used, total - i - 1, mem);
                    used[i] = 0;

                    if (canOpponentWin == false) {
                        mem.put(en, true);
                        return true;
                    }
                }
            }
        }

        mem.put(en, false);
        return false;
    }

    public int encode(int[] arr) {
        int n = 0;

        for (int i = 0; i < arr.length; i++) {
            n = n | arr[i];
            if (i != arr.length - 1) {
                n = n << 1;
            }
        }

        return n;
    }

    @Test
    public void t() {
        System.out.print(canIWin(10, 11));
    }
}
