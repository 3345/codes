package leetcode;

import java.util.*;

/**
 * Created by fyl on 1/16/17.
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[] {};
        }

        if (numCourses == 1) {
            return new int[] {0};
        }

        int[] order = new int[numCourses];

        if (prerequisites == null || prerequisites.length == 0) {
            //return true;
        }

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();
        List<Integer> orderList = new ArrayList<>();


        for (int j = 0; j < prerequisites.length; j++) {
            for (int i = 0; i < prerequisites[0].length; i++) {
                if (graph.containsKey(prerequisites[j][0])) {
                    graph.get(prerequisites[j][0]).add(prerequisites[j][1]);
                } else {
                    Set<Integer> set = new HashSet<>();
                    set.add(prerequisites[j][1]);
                    graph.put(prerequisites[j][0], set);
                }
            }
        }


        for (int i = 0; i < numCourses; i++) {
            if (!visited.contains(i)) {
                if (!search(i, visited, visiting, graph, orderList)) {
                    return new int[]{};
                }
            }


        }

        for (int i = 0; i < orderList.size(); i++) {
            order[i] = orderList.get(i);
        }

        return order;
    }


    public boolean search(int cur, Set<Integer> visited, Set<Integer> visiting, Map<Integer, Set<Integer>> graph, List<Integer> order) {
        if (visited.contains(cur)) {
            return true;
        }

        if (visiting.contains(cur)) {
            return false;
        }

        visiting.add(cur);

        if (!graph.containsKey(cur)) {
            visiting.remove(cur);
            visited.add(cur);
            order.add(cur);
            return true;

        } else {
            for (Integer next : graph.get(cur)) {
                if (!search(next, visited, visiting, graph, order)) {
                    return false;
                }
            }

            visiting.remove(cur);
            visited.add(cur);
            order.add(cur);
            return true;
        }
    }
}
