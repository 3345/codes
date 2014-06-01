package ch9;

import org.junit.Test;

public class p9_3 {
    public static int findIndex (int [] array, int target, int start, int end) {
        if (end < start)
            return -1;

        int mid = (int) Math.floor((end + start)/2);

        if (array[mid] == target)
            return mid;

        if (array[mid] > array[start]) {
            if (array[mid] < target)
                return findIndex(array, target, mid + 1, end);

            int maybe = findIndex(array, target, mid + 1, end);
            if (maybe != -1)
                return maybe;
            return findIndex(array, target, start, mid -1);
        }

        if (array[mid] > target)
            return findIndex(array, target, start, mid - 1);
        int maybe = findIndex(array, target, start, mid - 1);
        if (maybe != -1)
            return maybe;
        return findIndex(array, target, mid + 1, end);

    }

    @Test
    public void t1() {
        int [] array = {15,16,19,20,25,1,3,4,5,7,10,14};
        System.out.println(findIndex(array, 20, 0, array.length - 1));
    }

}
