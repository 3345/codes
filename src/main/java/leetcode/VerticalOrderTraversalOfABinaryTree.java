package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class VerticalOrderTraversalOfABinaryTree {
    Map<Integer, List<Node>> map = new HashMap<>();
    int min = 0;
    int max = 0;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        recur(root, 0, 0);
        for (int i = min; i <= max; i++) {
            List<Node> list = map.get(i);
            List<Integer> l = new ArrayList<>();
            if (list != null) {
                Collections.sort(list);
                list.forEach(o -> {
                    l.add(o.v);
                });
            }
            res.add(l);
        }
        return res;
    }

    public void recur(TreeNode node, int y, int x) {
        if (node == null) return;
        min = Math.min(y, min);
        max = Math.max(y, max);
        map.putIfAbsent(y, new ArrayList<>());
        map.get(y).add(new Node(x, node.val));
        recur(node.left, y - 1, x + 1);
        recur(node.right, y + 1, x + 1);
    }

    class Node implements Comparable<Node> {
        int x;
        int v;

        public Node(int x, int v) {
            this.x = x;
            this.v = v;
        }

        public int compareTo(Node o) {
            if (this.x == o.x) {
                return this.v - o.v;
            }
            return this.x - o.x;
        }
    }
}
