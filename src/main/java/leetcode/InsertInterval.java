package leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Created by yulai on 12/26/16.
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }

        int pos = findPosition(intervals, 0, intervals.size() - 1, newInterval.start);
        intervals.add(pos, newInterval);

        int p = Math.max(0, pos - 1);

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

    public int findPosition(List<Interval>intervals, int start, int end, int target) {
        if (start > end) {
            return start;
        }

        if(start == end) {
            int val = intervals.get(start).start;
            if (target > val) {
                return start + 1;
            } else {
                return start;
            }
        }
        if (start + 1 == end) {
            int val = intervals.get(start).start;
            if (val >= target) {
                return start;
            } else  {
                int ev = intervals.get(end).start;
                if (ev >= target) {
                    return end;
                } else {
                    return end + 1;
                }
            }
        }

        int mid = (start + end) / 2;
        int val = intervals.get(mid).start;

        if (val == target) {
            return mid;
        }

        if (target > val) {
            return findPosition(intervals, mid + 1, end, target);
        } else {
            return findPosition(intervals, start, mid, target);
        }
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

    @Test
    public void t() {
        Interval i15 = new Interval(0,5);
        List<Interval> list = new ArrayList<>();
        list.add(i15);
        list.add(new Interval(9,12));
        Interval i23 = new Interval(7,16);
        insert(list,i23);
    }

}
