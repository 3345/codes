package leetcode;

import org.junit.Test;

/**
 * 1/2^n probability return 1, other return 0
 */
public class ramdomNumber {
    public int random(int n) {
        int count = 0;
        for (int i = 0; i < n ;i ++) {
            if (Math.random() > 0.5)
                count++;
        }
        if (count == n)
            return 1;
        return 0;
    }

    @Test
    public void t1() {
        System.out.println(random(5));
    }
}
