package leetcode;

import java.util.*;

/**
 * Created by fyl on 12/18/16.
 */
public class FindTheCelebrity {
    boolean knows(int a, int b) {
        return true;
    }
    public int findCelebrity(int n) {
        List<Integer> maybeC = new ArrayList<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Set<Integer>> noMap = new HashMap<>();

        for (int i  = 0; i < n; i++) {
            maybeC.add(i);
        }


        int index = 0;
        int target = -1;
        while (maybeC.size() > 1) {
            if (target == -1) {
                target = index + 1;
            }

            if (index == target) {
                index ++;
                continue;
            }

            if (knows(maybeC.get(index), maybeC.get(target))) {
                if (!map.containsKey(target)) {
                    Set<Integer> set = new HashSet<>();
                    set.add(index);
                    map.put(target, set);
                } else {
                    map.get(target).add(index);
                }
                maybeC.remove(index);
                if (index < target) {
                    target --;
                }
            } else {
                if (!noMap.containsKey(target)) {
                    Set<Integer> set = new HashSet<>();
                    set.add(index);
                } else {
                    noMap.get(target).add(index);
                }

                maybeC.remove(target);
                if (target < index) {
                    target = index - 1;
                } else {
                    target = index;
                }
            }

        }

        if (maybeC.size() == 0) {
            return -1;
        }

        int c = maybeC.get(0);


        if (!map.containsKey(c)) {
            map.put(c, new HashSet<>());
        }

        if (!noMap.containsKey(c)) {
            noMap.put(c, new HashSet<>());
        }


        for (int i =0; i < n; i++) {
            if (i == c) {
                continue;
            }

            if (!map.get(c).contains(i)) {
                if (!knows(i, c)) {
                    return -1;
                }
            }

            if (!noMap.get(c).contains(i)) {
                if (knows(c, i)) {
                    return -1;
                }
            }
        }




        return c;
    }


}
