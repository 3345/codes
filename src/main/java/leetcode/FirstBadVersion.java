package leetcode;

import org.junit.Test;

/**
 You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

 Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

 You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API. */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        if (!isBadVersion(n)) {
            return  -1;
        }

        return findLeft(1, n);
    }

    private int findLeft(long start, long end) {
        if (start >= end) {
            return (int) start;
        }

        long mid = (start + end) / 2;

        if (!isBadVersion((int) mid)) {
            return findLeft(mid + 1, end);
        } else  {
            return findLeft(start, mid);
        }

    }

    private boolean isBadVersion(int version) {
        return version >= 2;
    }

    @Test
    public void test() {
        System.out.println(firstBadVersion(2126753390));
    }
}
