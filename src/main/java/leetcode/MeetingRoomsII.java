package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by fyl on 1/7/18.
 */
public class MeetingRoomsII {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }


    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (o1, o2) -> {return o1.start - o2.start;});
        PriorityQueue<Interval> q = new PriorityQueue<>((o1, o2) -> o1.end - o2.end);
        int rooms = 1;
        q.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            Interval top = q.peek();

            if (top.end <= intervals[i].start) {
                q.poll();
            } else {
                rooms++;
            }

            q.offer(intervals[i]);
        }

        return rooms;
    }

    @Test
    public void test() {
        Interval[] intervals = {new Interval(0, 30),new Interval(5, 10), new Interval(15, 20)};
        minMeetingRooms(intervals);
    }
}
