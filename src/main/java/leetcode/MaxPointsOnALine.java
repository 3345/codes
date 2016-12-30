package leetcode;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {

    class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }


    public int maxPoints(Point[] points) {
        if (points == null || points.length < 1) {
            return 0;
        }

        if (points.length < 2) {
            return 1;
        }

        int max = 0;

        for (int i = 0; i < points.length - 1; i++) {
            //slope, number of points
            Map<Double, Integer> map = new HashMap<>();
            int dup = 0;

            for (int j = i + 1; j < points.length; j ++) {
                double slope = Integer.MAX_VALUE;

                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    dup++;
                    continue;
                }

                if (points[i].y == points[j].y) {
                    slope = 0;
                } else if (points[i].x != points[j].x) {
                    slope = (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
                }

                if (map.containsKey(slope)) {
                    map.put(slope, map.get(slope) + 1);
                } else {
                    map.put(slope, 1);
                }
            }

            if (map.size() == 0) {
                max = Math.max(max, 1 + dup);
            } else {
                for (Double key : map.keySet()) {
                    max = Math.max(max, map.get(key) + dup + 1);
                }
            }
        }

        return max;
    }

    @Test
    public void t() {
        Point p1 = new Point(2,3);
        Point p2 = new Point(3,3);
        Point p3 = new Point(-5,3);
        Point[] points = new Point[]{p1,p2,p3};
        maxPoints(points);
    }
}
