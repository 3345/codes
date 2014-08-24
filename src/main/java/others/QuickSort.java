package others;

import org.junit.Test;

/**
 * Created by yfu on 8/22/14.
 */
public class QuickSort {
    public void quickSort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    public void sort(int[] a, int start, int end) {
        if (start == end)
            return;

        int start1 = start;
        int end1 = end;
        int pivot = (start + end)/2;

        while (start <= end) {
            if (a[start] >= a[pivot] && a[end] <= a[pivot]) {
                int tmp = a[end];
                a[end] = a[start];
                a[start] = tmp;
                start ++;
                end --;
                continue;
            }

            if (a[start] < a[pivot]) {
                start++;
            }

            if (a[end] > a[pivot])
                end --;
        }

        if (start1 < end)
            sort(a, start1, end);
        if (start < end1)
            sort(a, start, end1);
    }

    @Test
    public void test() {
        int[] a = {1,3,5,1,3,2,4};
        int[] b = {1,2,3,1};
        int[] c = {5,3,4};
        quickSort(a);
        quickSort(b);
        quickSort(c);
        print(a);
        print(b);
        print(c);
    }

    private void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

}
