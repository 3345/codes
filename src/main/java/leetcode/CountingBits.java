package leetcode;

import org.junit.Test;

/**
 * Created by fyl on 3/28/18.
 */
public class CountingBits {
    public int[] countBits(int num) {
        int[] ret = new int[num + 1];

        for (int i = 1; i < num + 1; i++) {
            int count = 0;
            int k = i;

            while (((k - 1) & 1) != 0) {
                count++;
                k = k >>> 1;
            }

            ret[i] = ret[i - 1] + 1 - count;
        }

        return ret;
    }

    @Test
    public void test() {
        this.countBits(5);
    }
}
