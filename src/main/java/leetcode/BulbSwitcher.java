package leetcode;

import org.junit.Test;

/**
 * Created by fuyul on 11/23/2017.
 */
public class BulbSwitcher {
    public int bulbSwitch(int n) {
        if (n == 0) {
            return 0;
        }

        int ans = 0;
        int i = 1;
        while (i*i <= n) {
            ans++;
            i ++;
        }

        return ans;
    }

    @Test
    public void test() {
        BulbSwitcher sol = new BulbSwitcher();
        sol.bulbSwitch(3);
    }
}
