package leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by fuyul on 1/3/2017.
 */
public class FlattenNestedListIterator {
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

    public class NestedIterator implements Iterator<Integer> {
        LinkedList<NestedInteger> ll = new LinkedList<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            for (NestedInteger ni : nestedList) {
                ll.add(ni);
            }

            unwrap();
        }

        private void unwrap() {
            while (ll.size() > 0 && !ll.peekFirst().isInteger()) {
                List<NestedInteger> list = ll.removeFirst().getList();
                for (int i = list.size() - 1; i > -1; i--) {
                    ll.addFirst(list.get(i));
                }
            }
        }

        @Override
        public Integer next() {
            Integer i = ll.removeFirst().getInteger();
            unwrap();
            return i;
        }

        @Override
        public boolean hasNext() {
            return !ll.isEmpty();
        }

        @Override
        public void remove() {

        }
    }
}
