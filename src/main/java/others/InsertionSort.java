package others;

import org.junit.Test;

/**
 1 5 3 2 4
 1 5 3 2 4
 1 3 5 2 5
 1 2 5 3 5
 1 2 3 5 5


 */
public class InsertionSort {
    public void sort(int[] a) {
        if (a == null || a.length == 1)
            return;
        for (int i = 1; i < a.length; i++) {
            int tmp = a[i];

            for (int j = i - 1; j >= 0; j --) {
                if (tmp < a[j]) {
                    a[j+1] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }

    @Test
    public void t() {
        int[] a = {3,1,1,5,4,6,7,5,3,8,3,9,10,9,6};
        sort(a);
        System.out.println(a.toString());
    }
}
