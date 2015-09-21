package leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Created by yulai on 9/20/15.
 */
public class PolindromeNumber {
    public boolean isPalindrome(int x) {
        List<Integer> digits = new ArrayList<>();

        int n = Math.abs(x);

        do {
            digits.add(n % 10);
            n = n / 10;
        } while (n != 0);

        int s = 0;
        int e = digits.size() - 1;
        while (e > s) {
            if (digits.get(s) != digits.get(e)) {
                return false;
            }

            s ++; e--;
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(isPalindrome(-2147447412));
    }
}
