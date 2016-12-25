package leetcode;

import org.junit.Test;

/**
 * Created by fyl on 12/24/16.
 */
public class ValidatePerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) {
            return true;
        }

        int lastDigit = getLastDigit(num);
        if (lastDigit != 1 && lastDigit != 4 && lastDigit != 9 && lastDigit != 6 && lastDigit != 5 && lastDigit != 0) {
            return false;
        }

        int start = 1;


        for(int i = 0; i < (getDigits(num) - 1)/ 2; i ++) {
            start *= 10;
        }

        int end = start * 100;

        return bs(num, start, end);
    }

    public int getDigits(int num) {
        if (num == 0) {
            return 1;
        }
        int n = 0;
        while (num > 0) {
            num /= 10;
            n++;
        }

        return n;
    }

    public int getLastDigit(int num) {
        return num - (num / 10) * 10;
    }

    public boolean bs(int target, long start, long end) {
        if (start > end) {
            return false;
        }

        long mid = (start + end) / 2;
        long sq = mid * mid;
        if (sq == target) {
            return  true;
        } else if (sq > target) {
            return bs(target, start, mid - 1);
        } else {
            return bs(target, mid + 1, end);
        }
    }

    @Test
    public void t() {
        System.out.println(isPerfectSquare(2147395600));
    }
}
