package leetcode;

import org.junit.Test;

public class MergeSort {
    public void mergeSort(int[] a) {
        if (a == null || a.length <= 1)
            return;
        sort(a, 0, a.length - 1);
    }

    public void sort(int[] a, int low, int high) {
        if (low == high)
            return;

        int mid = (low + high) / 2;

        sort(a, low, mid);
        sort(a, mid + 1, high);
        merge(a, low, high, mid);
    }

    public void merge(int[] a, int low, int high, int mid) {
        if (high == low)
            return;

        int[] temp = new int[a.length];

        for (int i = 0; i < a.length; i ++) {
            temp[i] = a[i];
        }

        int low2 = mid + 1;
        int pointer = low;

        while (low <= mid && low2 <= high) {
            if (temp[low] < temp[low2]) {
                a[pointer] = temp[low];
                low ++;
            } else {
                a[pointer] = temp[low2];
                low2++;
            }
            pointer++;
        }

        while (low <= mid) {
            a[pointer] = temp[low];
            pointer++;
            low++;
        }

        while (low2 <= high) {
            a[pointer] = temp[low2];
            pointer++;
            low2++;
        }

    }

    @Test
    public void test() {
        int[] a = {1,3,5,1,3,2,4};
        int[] b = {1,2,3,1};
        int[] c = {5,3,4};

        mergeSort(a);
        mergeSort(b);
        mergeSort(c);

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

    @Test
    public void test1() {
        int[] a = {1,1,3,5,2,3,4};
        merge(a, 0, 6, 3);
    }

}
