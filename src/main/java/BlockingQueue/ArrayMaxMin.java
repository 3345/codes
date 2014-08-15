package BlockingQueue;

import org.junit.Test;

public class ArrayMaxMin {
    /**
     *  Time O(n)
     *  Space O(1)
     */
    public static void find(double[] a) {
        double max1 = Double.MIN_VALUE;
        double max2 = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;

        for (int i = 0; i < a.length; i ++) {
            if (a[i] > Math.min(max1, max2)) {
                if (max1 > max2)
                    max2 = a[i];
                else
                    max1 = a[i];
            }
            min = Math.min(min, a[i]);
        }

        System.out.println(String.format("the two largest numbers are %s, %s", max1, max2));
        System.out.println(String.format("the smallest number is %s", min));
    }

    @Test
    public void test() {
        double[] b = {1,1,2,3};
        double[] a = {2,3,5,-100, -23, 1.4, -3.4545, -100,4,5,3,19};
        find(a);
    }
}
