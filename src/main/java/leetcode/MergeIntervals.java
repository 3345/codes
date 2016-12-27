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
        if (intervals == null) {
            return new ArrayList<>();
        }

        if (intervals.size() < 2) {
            return intervals;
        }

        Collections.sort(intervals, new IntervalComparator());

        int p = 0;

        while (p < intervals.size() - 1) {
            Interval merged = mergeTwo(intervals.get(p), intervals.get(p + 1));
            if (merged == null) {
                p++;
                continue;
            }

            intervals.remove(p);
            intervals.remove(p);
            intervals.add(p, merged);
        }

        return intervals;


    }

    //i1's start <= i2's start
    private Interval mergeTwo(Interval i1, Interval i2) {

        if (i2.start - i1.end > 0) {
            return null;
        }

        return new Interval(i1.start, Math.max(i1.end, i2.end));
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
                return 0;
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

