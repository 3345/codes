package leetcode;

import org.junit.Test;

/**
 Given an array of non-negative integers, you are initially positioned at the first index of the array.
 Each element in the array represents your maximum jump length at that position.
 Determine if you are able to reach the last index.
 For example:
 A = [2,3,1,1,4], return true.
 A = [3,2,1,0,4], return false.
 */
public class JumpGame {
    public boolean canJump(int[] a) {
        if (a == null)
            return false;
        int farthest = 0;
        for (int i = 0; i < a.length; i ++) {
            if (i > farthest)
                return false;
            farthest = Math.max(farthest, a[i] + i);
            if (farthest >= a.length - 1)
                return true;
        }
        return true;
    }

    @Test
    public void test1() {
        int [] a = {2,3,1,1,4};
        int [] a1 = {3,2,1,0,4};
        System.out.println(canJump(a));
        System.out.println(canJump(a1));
    }
}
