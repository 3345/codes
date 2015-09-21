package leetcode;

import org.junit.Test;

import java.util.*;

/**
 Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].
 */
public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        TreeSet<Interval> treeSet = new TreeSet<Interval>(new IntervalComparator());
        treeSet.addAll(intervals);
        List<Interval> result = new ArrayList<Interval>();
        Iterator<Interval> iterator = treeSet.iterator();
        Interval i1 = iterator.next();

        while (true) {
            if (iterator.hasNext()) {
                Interval i2 = iterator.next();
                Interval i = mergeTwo(i1, i2);
                if (i != null) {
                    i1 = i;
                } else {
                    result.add(i1);
                    //result.add(i2);
                    i1 = i2;
                }
            } else {
                result.add(i1);
                return result;
            }

        }
    }

    private Interval mergeTwo(Interval i1, Interval i2) {
        Interval result = null;
        if (i1.end >= i2.start) {
            result = new Interval(i1.start, Math.max(i1.end, i2.end));
        }
        return result;
    }

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public class IntervalComparator implements Comparator<Interval> {

        @Override
        public int compare(Interval i1, Interval i2) {
            if (i1.start > i2.start)
                return 1;
            if (i1.start == i2.start) {
                if (i1.end == i2.end)
                    return 0;
                if (i1.end < i2.end)
                    return -1;
                else
                    return 1;
            }
            return -1;
        }
    }

    /**
     For example,
     Given [1,3],[2,6],[8,10],[15,18],
     return [1,6],[8,10],[15,18].
     */

    @Test
    public void test() {
        Interval i1 = new Interval(1,6);
        List<Interval> list = new ArrayList<Interval>();
        list.add(new Interval(1,3));
        list.add(new Interval(2,6));
        list.add(new Interval(8,10));
        list.add(new Interval(2,18));
        List l = merge(list);
        System.currentTimeMillis();

    }

}

