package leetcode;

import org.junit.Test;

import java.util.*;

public class MostStoneRemovedWithSameRowOrColumn {
    public int removeStones(int[][] stones) {
        Map<Integer, List<Node>> xmap = new HashMap<>();
        Map<Integer,List<Node>> ymap = new HashMap<>();
        List<Node> all = new ArrayList<>();

        for (int i = 0; i < stones.length; i++) {
            int x = stones[i][0]; int y = stones[i][1];
            Node n = new Node(x,y);
            all.add(n);
            xmap.putIfAbsent(x, new ArrayList<>());
            xmap.get(x).add(n);
            ymap.putIfAbsent(y, new ArrayList<>());
            ymap.get(y).add(n);
        }

        for (List<Node> values : xmap.values()) {
            Iterator<Node> iter = values.iterator();
            Node first = iter.next();
            while (iter.hasNext()) {
                Node.union(first, iter.next());
            }
        }
        for (List<Node> values : ymap.values()) {
            Iterator<Node> iter = values.iterator();
            Node first = iter.next();
            while (iter.hasNext()) {
                Node.union(first, iter.next());
            }
        }
        Set<Node> set = new HashSet<>();
        for (Node n:all) {
            set.add(n.findSet());
        }
        return stones.length - set.size();

    }

    static class Node {
        int x;
        int y;
        int rank = 0;
        Node parent;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.parent = this;
        }

        public Node findSet() {
            Node root = this.parent;
            while (root != root.parent) {
                root = root.parent;
            }
            this.parent = root;
            return root;
        }

        public static void union(Node a, Node b) {
            Node ar = a.findSet();
            Node br = b.findSet();
            if (ar != br) {
                if (ar.rank >= br.rank) {
                    br.parent = ar;
                    ar.rank++;
                } else {
                    ar.parent = br;
                    br.rank++;
                }
            }
        }
    }

    @Test
    public void test() {
        int[][] input = new int[][]{{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        removeStones(input);
    }
}
