package leetcode;

import org.junit.Test;

/**
 * Created by fyl on 12/11/16.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[0];
        }

        if (digits.length == 1) {
            if (digits[0] != 9) {
                int[] arr = {digits[0] + 1};
                return arr;
            } else {
                int[] arr = {1,0};
                return arr;
            }
        }

        int firstNotNine = -1;
        int endIndex = digits.length - 1;

        if (digits[endIndex] != 9) {
            digits[endIndex] = digits[endIndex] + 1;
            return digits;
        }

        for (int i = digits.length - 2; i > -1; i --) {
            if (digits[i] == 9) {
                continue;
            } else {
                firstNotNine = i;
                break;
            }
        }

        if (firstNotNine != -1) {
            digits[firstNotNine] = digits[firstNotNine] + 1;
            for (int i = firstNotNine + 1; i < digits.length; i++) {
                digits[i] = 0;
            }
            return digits;
        } else {
            int[] arr = new int[digits.length + 1];
            arr[0] = 1;
            return arr;
        }


    }

    @Test
    public void t() {
        plusOne(new int[]{2,4,9,3,9});
    }
}
