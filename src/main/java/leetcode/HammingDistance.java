package leetcode;

/**
 * Created by fyl on 1/23/17.
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
