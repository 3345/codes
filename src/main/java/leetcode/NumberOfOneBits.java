package leetcode;

/**
 * Created by yulai.fu on 10/22/17.
 */
public class NumberOfOneBits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int r = 0;
        while (n != 0) {
            r += n & 1;
            n = n >>> 1;
        }
        return r;
    }
}
