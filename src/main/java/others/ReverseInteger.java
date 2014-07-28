package others;

import org.junit.Test;

public class ReverseInteger {
    public int reverse(int x) {
        boolean isPositive = x > 0;
        x = Math.abs(x);
        int ans = 0;
        while (x > 0) {
            int digit = x % 10;
            ans = ans*10 + digit;
            x = x/10;
        }
        return isPositive ? ans : -ans;
    }

    @Test
    public void test() {
        System.out.println(reverse(1));
    }
}
