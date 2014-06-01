package ch8;

import org.junit.Test;

public class p8_2 {

    public static int numPath(int x, int y) {
        int result = 0;

        if (x - 1 >= 0)
            result += numPath(x - 1, y);
        if (y - 1 >= 0)
            result += numPath(x, y - 1);

        if (x == 0 && y == 0)
            return 1;

        return result;
    }


    @Test
    public void t1() {
        System.out.println(numPath(3,3));
    }

}

