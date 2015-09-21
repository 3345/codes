package leetcode;

import org.junit.Test;

import java.util.*;

public class CloneGraph {

     class UndirectedGraphNode {
         int label;
         List<UndirectedGraphNode> neighbors;
         UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
     };

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;

        Map<UndirectedGraphNode, UndirectedGraphNode> pairs = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        return clone(node, pairs);

    }

    public UndirectedGraphNode clone(UndirectedGraphNode node,
                                     Map<UndirectedGraphNode, UndirectedGraphNode> pairs) {
        if (pairs.containsKey(node))
            return pairs.get(node);

        UndirectedGraphNode node1 = new UndirectedGraphNode(node.label);
        pairs.put(node, node1);

        List<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();

        for (UndirectedGraphNode neighbor : node.neighbors) {
            neighbors.add(clone(neighbor, pairs));
        }
        node1.neighbors = neighbors;
        return node1;
    }

    @Test
    public void t1() {
        UndirectedGraphNode node = new UndirectedGraphNode(0);
        node.neighbors = Arrays.asList(node, node);
        UndirectedGraphNode n = cloneGraph(node);
        System.out.println();
    }
}
