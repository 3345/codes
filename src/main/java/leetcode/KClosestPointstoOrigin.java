package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class KClosestPointstoOrigin {
    public int[][] kClosest(int[][] points, int k) {
        List<int[]> list = new ArrayList<>();
        helper(points, k, 0, points.length - 1, list);
        int[][] ret = new int[k][2];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    public static void helper(int[][] points, int k, int l, int r, List<int[]> list) {
        int pivot = partition(points, l, r);
        if (pivot - l  + 1 <= k) {
            for (int i = l; i < pivot + 1; i++) {
                list.add(points[i]);
            }
            if (pivot - l + 1 == k) {
                return;
            } else {
                helper(points, k - (pivot - l + 1), pivot + 1, r, list);
            }
        } else {
            helper(points, k, l, pivot - 1, list);
        }
    }

    private static int partition(int[][] arr, int l, int r) {
        if (l == r) {
            return l;
        }
        int pivot = l;
        int border = l + 1;
        int i = l + 1;
        while (i <= r) {
            if (dist(arr[i]) < dist(arr[pivot])) {
                swap(arr, border, i);
                border++;
            }
            i++;
        }
        swap(arr, pivot, border - 1);

        return border - 1;
    }

    private static int dist(int[] point) {
        return point[0]*point[0] + point[1]* point[1];
    }

    private static void swap(int[][] arr, int i, int j) {
        int[] t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    @Test
    public void test() {
        //[[3,3],[5,-1],[-2,4]]
        int[][] points = new int[][] {{1,3},{-2,2},{2,-2}};
        int k = 2;
        KClosestPointstoOrigin sol = new KClosestPointstoOrigin();
        int[][] ans = sol.kClosest(points, k);
        System.out.println("");

    }
}
