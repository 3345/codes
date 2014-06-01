package ch4;

import dataStructure.MyTreeNode;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class p4_2 {
    public static boolean hasPath(MyTreeNode node1, MyTreeNode node2, Set<MyTreeNode> visited) {
        for (Object obj : node1.children) {
            MyTreeNode child = (MyTreeNode)obj;

            if (visited.contains(child))
                continue;

            visited.add(child);

            if (child.equals(node2))
                return true;

            if (!child.isLeaf()) {
                if (hasPath(child, node2, visited))
                    return true;
            }
        }
        return false;
    }

    @Test
    public void t1() throws Exception {

        MyTreeNode n1 = new MyTreeNode(1);
        MyTreeNode n2 = new MyTreeNode(2);
        MyTreeNode n3 = new MyTreeNode(3);
        MyTreeNode n4 = new MyTreeNode(4);
        MyTreeNode n5 = new MyTreeNode(5);

        n1.addChildNode(n2);
        n2.addChildNode(n3).addChildNode(n4);
        n4.addChildNode(n5);
        n5.addChildNode(n3);
        n3.addChildNode(n5);

        assertTrue(hasPath(n1, n3, new HashSet<MyTreeNode>()));
        assertTrue(hasPath(n4, n3, new HashSet<MyTreeNode>()));
        assertFalse(hasPath(n5, n1, new HashSet<MyTreeNode>()));
        assertFalse(hasPath(n3, n4, new HashSet<MyTreeNode>()));
    }

}
