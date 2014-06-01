package ch8;

import org.junit.Test;

public class p8_1 {
    public int fib(int n) {
        if (n == 0 || n == 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

    @Test
    public void t1() {
        System.out.println(fib(3));
    }
}
