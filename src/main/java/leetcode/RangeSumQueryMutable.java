package leetcode;

public class RangeSumQueryMutable {
    class NumArray {
        int[] tree;
        int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
            this.tree = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                this.add(i, nums[i]);
            }
        }

        public void update(int i, int val) {
            this.add(i, val-nums[i]);
            nums[i] = val;
        }

        private void add(int i, int val) {
            i = i + 1;
            while (i < tree.length) {
                tree[i] += val;
                i += lsb(i);
            }
        }

        public int sumRange(int i, int j) {
            return prefixSum(j) - prefixSum(i - 1);
        }

        private int lsb(int i) {
            return i & (-i);
        }

        private int prefixSum(int i) {
            i = i + 1;
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= lsb(i);
            }
            return sum;
        }

    }
}
