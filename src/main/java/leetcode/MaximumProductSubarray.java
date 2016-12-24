package leetcode;

import org.junit.Test;

/**
 * Created by fuyul on 12/22/2016.
 */
public class MaximumProductSubarray {
    public class Node {
        Integer pos = null;
        Integer neg = null;

        public Node() {}

        public Node (Integer pos, Integer neg) {
            this.pos = pos;
            this.neg = neg;
        }
    }

    public int maxProduct(int[] nums) {

        Node[] mem = new Node[nums.length];
        Node n = new Node();
        if (nums[0] >= 0) {
            n.pos = nums[0];
        } else {
            n.neg = nums[0];
        }

        mem[0] = n;

        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            Node n1 = new Node();
            if (nums[i] >= 0) {
                if (mem[i-1].pos != null && mem[i - 1].pos != 0) {
                    n1.pos = mem[i-1].pos * nums[i];
                } else {
                    n1.pos = nums[i];
                }

                if (mem[i-1].neg != null) {
                    n1.neg = mem[i-1].neg * nums[i];
                }
            } else {
                if (mem[i-1].neg != null) {
                    n1.pos = mem[i-1].neg * nums[i];
                }

                n1.neg = nums[i];

                if (mem[i-1].pos != null && mem[i-1].pos != 0) {
                    n1.neg = mem[i-1].pos * nums[i];
                }
            }
            if (n1.pos != null) {
                max = Math.max(max, n1.pos);
            } else {
                max = Math.max(max, n1.neg);
            }
            mem[i] = n1;
        }

        return max;
    }

    @Test
    public void t() {
        int[] input = new int[]{0,-2,-3};
        maxProduct(input);
    }
}
