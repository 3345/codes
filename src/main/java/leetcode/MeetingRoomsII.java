package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by fyl on 1/7/18.
 */
public class MeetingRoomsII {


    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int rooms = 1;
        q.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] top = q.peek();

            if (top[2] <= intervals[i][0]) {
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

    }
}
