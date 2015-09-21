package leetcode;

import org.junit.Test;

public class SqrtRoot {
    public int sqrt(int x) {
        if (x == 1)
            return x;
        return (int) solve(0, x, x);
    }

    public double solve(long low, long high, int target) {
        long mid = (high + low)/2;
        if (mid == low || mid == high)
            return mid;

        if (mid*mid > target && mid*mid < target)
            return mid;
        else if (mid*mid > target)
            return solve(low, mid, target);
        else
            return solve(mid, high, target);

    }

    @Test
    public void t() {
        //sqrt(2147395599);
        System.out.println(sqrt(2147395599));
    }

}
