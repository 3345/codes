package leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by fuyul on 1/16/2017.
 */
public class HIndex {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        Arrays.sort(citations);

        int index = 0;

        for (int i = citations.length - 1; i > 0; i--) {
            if (index >= citations[i] || index >= citations.length - i) {
                break;
            }
            index = Math.max(Math.min(citations[i], citations.length - i), index);
        }

        return index;
    }

    @Test
    public void t(){
        hIndex(new int[] {1});
    }
}
