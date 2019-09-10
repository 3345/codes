package leetcode;

import org.junit.Test;

public class MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] A, int[] B) {
        int n1 = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        for (int i = 0; i < 6; i++) {
            int a = A[i];
            int b = B[i];
            if (a == A[0]) {
                n1++;
            }
            if (a == B[0]) {
                n2++;
            }
            if (b == A[0]) {
                n3++;
            }
            if (b == B[0]) {
                n4++;
            }
            if ((a != A[0] && a != B[0]) || (b != A[0] && b != B[0])) return -1;
        }
        return 6 - Math.max(Math.max(n1,n2), Math.max(n3,n4));
    }

    @Test
    public void test() {
        int[] A = new int[]{2,1,2,4,2,2};
        int[] B = new int[]{5,2,6,2,3,2};
        minDominoRotations(A, B);
    }


}
