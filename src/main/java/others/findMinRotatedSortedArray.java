package others;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class findMinRotatedSortedArray {
    public int min(int[] arr, int start, int end) {
        if (arr.length == 0)
            return 0;
        if (arr.length == 1)
            return arr[0];
        int mid = (int) Math.ceil((start + end)/2);
        if (arr[mid] < arr[mid - 1])
            return arr[mid];
        if (arr[mid] < arr[start]) {
            return min(arr, start, mid - 1);
        } else if (arr[mid] > arr[end]) {
            return min(arr, mid + 1, end);
        } else {
            return arr[0];
        }
    }

    @Test
    public void t() {
        int [] a = {6,7,1,2,3,4,5};
        assertEquals(1, min(a, 0, a.length - 1));
    }

    @Test
    public void t1() {
        int [] a = {1,2,3,4,5};
        assertEquals(1, min(a, 0, a.length - 1));
    }

    @Test
    public void t2() {
        int [] a = {2,3,4,5,1};
        assertEquals(1, min(a, 0, a.length - 1));
    }
}
