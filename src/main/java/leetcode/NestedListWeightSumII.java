package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedListWeightSumII {

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {
        // Constructor initializes an empty nested list.
        //public NestedInteger();

        // Constructor initializes a single integer.
        //public NestedInteger(int value);

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }


    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }

        List<Integer> list = new ArrayList<>();
        Queue<NestedInteger> q = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();
        int curLevel = 0;

        for (NestedInteger n : nestedList) {
            q.add(n);
            level.add(0);
        }

        int levelSum = 0;

        while(!q.isEmpty()) {
            NestedInteger n = q.poll();

            if (level.poll() > curLevel) {
                curLevel++;
                list.add(levelSum);
                levelSum = 0;
            }

            if (n.isInteger()) {
                levelSum += n.getInteger();
            } else {
                for (NestedInteger ni : n.getList()) {
                    q.add(ni);
                    level.add(curLevel + 1);
                }
            }
        }

        list.add(levelSum);

        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += (list.size() - i) * list.get(i);
        }

        return sum;
    }

}
