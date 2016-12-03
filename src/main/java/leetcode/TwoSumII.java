package leetcode;

/**
 * Created by yulai on 12/1/16.
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int p1 = 0;
        int p2 = numbers.length - 1;

        while (p1 < p2) {
            int n1 = numbers[p1];
            int n2 = numbers[p2];

            if (n1 + n2 > target) {
                p2 --;
            } else if (n1 + n2 < target) {
                p1 ++;
            } else {
                return new int[]{p1+1, p2+1};
            }
        }

        return new int[2];
    }


}
