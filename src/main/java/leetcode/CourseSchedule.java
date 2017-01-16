package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by fyl on 1/15/17.
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses < 2) {
            return true;
        }

        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();


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
                if (!search(i, visited, visiting, graph)) {
                    return false;
                }
            }


        }

        return true;
    }


    public boolean search(int cur, Set<Integer> visited, Set<Integer> visiting, Map<Integer, Set<Integer>> graph) {
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
            return true;

        } else {
            for (Integer next : graph.get(cur)) {
                if (!search(next, visited, visiting, graph)) {
                    return false;
                }
            }

            visiting.remove(cur);
            visited.add(cur);
            return true;
        }
    }

    @Test
    public void t() {
        int[][] p = {{0,1}, {1,0}};

        boolean b = canFinish(2, p);
        System.out.print(b);
    }
}
