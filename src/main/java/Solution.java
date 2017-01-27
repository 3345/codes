import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * There are 10 people at a wizard meetup. Each wizard has levels 0 - 9 (the index of the input) and 
 * knows a few other wizards there. Your job is to find the cheapest way for wizard 0 to meet wizard 9.
 * Introductions have a cost that equals the square of the difference in levels. 

 * Goal: Level 0 wizard wants to meet level 9 using the fewest possible magic points.
 * Cost: square of difference of levels
 * The index of the input array represents the level (0-9)
 * the value is an array with the index of the other people each person knows. Note that relationships are one directional (e.g. 2 can introduce you to 3 but not vice versa)
*/


/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
    static List<List<Integer>> wizards = asList(
            asList(1, 2, 3), // Wizard 0
            asList(8, 6, 4), // Wizard 1
            asList(7, 8, 3), // Wizard 2
            asList(8, 1),    // Wizard 3
            asList(6),       // Wizard 4
            asList(8, 7),    // Wizard 5
            asList(9, 4),    // Wizard 6
            asList(4, 7),    // Wizard 7
            asList(1),       // Wizard 8
            asList(1, 4)     // Wizard 9
    );

    class Node {
        int cost;
        int level;
        List<Integer> order;

        public Node (int cost, int level, List<Integer> order) {
            this.cost = cost;
            this.level = level;
            this.order = order;
        }
    }

    class Result {
        int cost;
        List<Integer> order;

        public Result(int cost, List<Integer> order) {
            this.cost = cost;
            this.order = order;
        }
    }

    public  Result search() {
        List<Integer> order = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        PriorityQueue<Node> q = new PriorityQueue<>(
                new Comparator<Node>() {
                    public int compare(Node o1, Node o2) {
                        return o1.cost - o2.cost;
                    }}
        );

        order.add(0);

        for (int index : wizards.get(0)) {
            q.add(new Node(index * index, 0, order));
        }

        while(!q.isEmpty()) {
            Node shortest = q.poll();
            order.add(shortest.level);

            visited.add(shortest.level);

            if (shortest.level == 9) {
                return new Result(shortest.cost, shortest.order);
            } else {
                for (int nextIndex : wizards.get(shortest.level)) {
                    if (!visited.contains(shortest.level)) {
                        List<Integer> nextOrder = new ArrayList<>();
                        for (int i : shortest.order) {
                            nextOrder.add(i);
                        }
                        nextOrder.add(nextIndex);

                        q.add(new Node((shortest.level - nextIndex) * (shortest.level - nextIndex) + shortest.cost,
                                nextIndex, nextOrder));
                    }
                }
            }
        }

        return null;

    }



}
