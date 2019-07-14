package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by fyl on 6/13/19.
 */
public class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int d12 = this.dist(p1, p2);
        int d13 = this.dist(p1, p3);
        int d14 = this.dist(p1, p4);
        int d23 = this.dist(p2, p3);
        int d24 = this.dist(p2, p4);
        int d34 = this.dist(p3, p4);


        if (d12 == 0 || d13 == 0 || d14 == 0 || d23 == 0 || d24 == 0 || d34 == 0) {
            return false;
        }

        int[] arr = new int[]{d12,d13,d14,d23,d24,d34};
        Arrays.sort(arr);
        int min = arr[0];
        for (int i = 0; i < 4; i ++) {
            if (arr[i] != min) {
                return false;
            }
        }
        for (int i = 4; i < 6; i++) {
            if (arr[i] != 2*min) {
                return false;
            }
        }
        return true;
    }

    public int dist(int[] p1, int[] p2) {
        int d1 =  p1[0] - p2[0];
        int d2 = p1[1] - p2[1];
        return d1*d1 + d2*d2;
    }

    @Test
    public void test() {
        ValidSquare sol = new ValidSquare();
        int[] p1 = new int[]{0,0};
        int[] p2 = new int[]{1,1};
        int[] p3 = new int[]{1,0};
        int[] p4 = new int[]{0,1};

        sol.validSquare(p1,p2,p3,p4);

    }
}
