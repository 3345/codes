package leetcode;


import java.util.List;

public class NestedListWeightSum {
      public interface NestedInteger {
 
              // @return true if this NestedInteger holds a single integer, rather than a nested list.
              public boolean isInteger();
 
              // @return the single integer that this NestedInteger holds, if it holds a single integer
              // Return null if this NestedInteger holds a nested list
              public Integer getInteger();
 
              // @return the nested list that this NestedInteger holds, if it holds a nested list
              // Return null if this NestedInteger holds a single integer
              public List<NestedInteger> getList();
  }
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.isEmpty()) {
            return 0;
        }

        int sum = 0;
        for (NestedInteger i : nestedList) {
            sum += doDepth(i, 1);
        }

        return sum;
    }

    public int doDepth(NestedInteger ni, int depth) {
          if (ni.isInteger()) {
              return ni.getInteger() * depth;
          } else {
              int sum = 0;
              for (NestedInteger nni : ni.getList()) {
                  sum += doDepth(nni, depth + 1);
              }
              return sum;
          }
    }
}
