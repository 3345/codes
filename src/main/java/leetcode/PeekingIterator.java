package leetcode;

import java.util.Iterator;

/**
 * Created by fyl on 3/25/18.
 */
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iter = null;
    private Integer cur = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iter = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (iter == null) {
            return null;
        }

        if (cur != null) {
            return cur;
        }

        if (iter.hasNext()) {
            cur = iter.next();
            return cur;
        } else {
            return null;
        }
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (cur != null) {
            int temp = cur.intValue();
            cur = null;
            return temp;
        }

        if (iter.hasNext()) {
            return iter.next();
        }

        return null;
    }

    @Override
    public boolean hasNext() {
        if (cur != null) {
            return true;
        }

        if (iter == null) {
            return false;
        }

        return iter.hasNext();
    }
}