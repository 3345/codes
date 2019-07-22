package leetcode;

import org.junit.Test;

import java.util.*;

public class CloneGraph {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            Node n = q.poll();
            if (visited.contains(n)) {
                continue;
            }
            visited.add(n);
            map.putIfAbsent(n, new Node(node.val, new ArrayList<>()));
            Node n1 = map.get(n);
            map.put(n, n1);
            for (Node nb : n.neighbors) {
                if (!visited.contains(nb)) {
                    q.add(nb);
                }
                map.putIfAbsent(nb, new Node(nb.val, new ArrayList<>()));
                Node nb1 = map.get(nb);
                n1.neighbors.add(nb1);
            }
        }
        return map.get(node);
    }

    @Test
    public void t1() {
        Node n1 = new Node(1, new ArrayList<>());
        Node n2 = new Node(2, new ArrayList<>());
        Node n3 = new Node(3, new ArrayList<>());
        Node n4 = new Node(4, new ArrayList<>());
        n1.neighbors.addAll(Arrays.asList(n2,n4));
        n2.neighbors.addAll(Arrays.asList(n1,n3));
        n3.neighbors.addAll(Arrays.asList(n2,n4));
        n4.neighbors.addAll(Arrays.asList(n1,n3));
        this.cloneGraph(n1);
        System.out.println();
    }
}
