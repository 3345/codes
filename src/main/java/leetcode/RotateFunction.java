package leetcode;

/**
 * Created by fyl on 12/4/16.
 */
public class RotateFunction {
    public int maxRotateFunction(int[] a) {
        if (a == null || a.length < 2) {
            return 0;
        }

        int sum = 0;
        int f0 = 0;

        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            f0 += i * a[i];
        }

        int max = f0;

        for (int i = 1; i < a.length; i++) {
            int f1 = a.length * a[i - 1] - sum + f0;
            max = Math.max(max, f1);
            f0 = f1;
        }

        return max;

    }
}
