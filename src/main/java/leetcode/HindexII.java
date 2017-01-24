package leetcode;

import org.junit.Test;

/**
 * Created by fyl on 1/23/17.
 */
public class HindexII {
    public int hIndex(int[] citations) {
        return solve(citations, 0, citations.length - 1);
    }

    public int solve(int[] citations, int start, int end) {
        if (start > end) {
            return  0;
        }

        if (start == end) {
            return Math.min(citations[start], citations.length - start);
        }

        int mid = (start + end) / 2;

        if (citations.length - mid < citations[mid]) {
            return solve(citations, start, mid);
        } else {
            return Math.max(solve(citations, mid + 1, end), citations[mid]);
        }

    }

    @Test
    public void t() {
        int[] arr = new int[] {1,2,2};
        System.out.println(hIndex(arr));
    }
}
