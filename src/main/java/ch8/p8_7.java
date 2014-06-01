package ch8;

import org.junit.Test;

import java.util.List;
import java.util.Set;

public class p8_7 {
    public static int change(int amount, int nomination) {
        int nextNom = 0;

        switch (nomination) {
            case 25: nextNom = 10;
                break;
            case 10: nextNom = 5;
                break;
            case 5: nextNom = 1;
                break;
            case 1:
                return 1;
        }

        int ways = 0;

        for (int i = 0; amount - i*nomination >=0; i ++) {
            ways += change(amount - i*nomination, nextNom);
        }

        return ways;
    }

    public static int change(int amount) {
        return change(amount, 25);
    }

    @Test
    public void t1() {
        System.out.println(change(10));
    }
}
