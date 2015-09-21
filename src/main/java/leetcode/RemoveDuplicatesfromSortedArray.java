package leetcode;

import org.junit.Test;

/**
 Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array A = [1,1,2],

 Your function should return length = 2, and A is now [1,2].
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] a) {
        if (a == null || a.length == 0)
            return 0;
        if (a.length == 1) {
            return 1;
        }

        int pointer = 1;

        for (int i = 0; i < a.length - 1; i ++) {
            if (a[i] != a[i + 1]) {
                a[pointer] = a[i + 1];
                pointer ++;
            }
        }
        return pointer;
    }

    @Test
    public void test() {
        int[] a = {1,1,1,1,2,2,2,2,2,2,3,3,3,3,4,4,4};
        System.out.println(removeDuplicates(a));
        System.out.println(a);
    }
}
