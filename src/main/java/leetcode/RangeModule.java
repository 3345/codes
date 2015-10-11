package leetcode;

import org.junit.Test;

import java.net.Inet4Address;
import java.util.TreeMap;

/**
 * Created by fyl on 10/3/15.
 */
public class RangeModule {

    TreeMap<Integer, Integer> ranges = new TreeMap<Integer, Integer>();

    public void AddRange(int lower, int upper) {

        if (ranges.size() == 0) {
            ranges.put(lower, upper);
        }

        Integer upperFloor = ranges.floorKey(upper);
        Integer lowerFloor = ranges.floorKey(lower);
        Integer lowerCeiling = ranges.ceilingKey(lower);


        Integer removeStart = null;

        Integer removeEnd = upperFloor;

        Integer insertLower = lower;

        Integer insertUpper = upper;

        if (lowerFloor != null) {
            Integer lowerFloorValue = ranges.get(lowerFloor);

            removeStart = lowerFloorValue < lower ? lowerCeiling : lowerFloor;

            insertLower = lowerFloorValue < lower ? lower : lowerFloor;
        }

        if (upperFloor != null) {
            Integer upperFloorValue = ranges.get(upperFloor);

            if (upperFloorValue < lower) {
                removeEnd = null;
            }

            insertUpper = upperFloorValue < upper ? upper : upperFloorValue;
        }


        if (removeEnd  != null) {

            if (removeStart == null) {
                ranges.headMap(removeEnd, true).clear();
            } else if (removeEnd >= removeStart) {
                ranges.subMap(removeStart, true, removeEnd, true).clear();
            }
        }

        ranges.put(insertLower, insertUpper);
    }

    public boolean QueryRange(int lower, int upper) {
        if (ranges.size() == 0) {
            return false;
        }

        Integer lowerFloor = ranges.floorKey(lower);

        if (null == lowerFloor) {
            return false;
        } else {
            Integer lowerFloorValue = ranges.get(lowerFloor);
            return lowerFloorValue >= upper;
        }


    }

//    public void DeleteRange(int lower, int upper) {
//        if (!QueryRange(lower, upper)) {
//            return;
//        }
//
//        Integer lowerFloor = ranges.floorKey(lower);
//        Integer removeStart = null;
//        Integer removeEnd = null;
//
//        if (lowerFloor != null) {
//            Integer lowerFloorValue = ranges.get(lowerFloor);
//            if (lowerFloorValue  < lower) {
//                Integer lowerCeiling = ranges.ceilingKey(lower);
//                if (lowerCeiling < )
//            } else {
//                removeStart =
//            }
//        }
//    }


    @Test
    public void test() {
        RangeModule sol = new RangeModule();
        sol.AddRange(10, 200);
        sol.AddRange(150, 180);
        sol.AddRange(250, 500);

        System.out.println(sol.QueryRange(50, 100));
    }

}