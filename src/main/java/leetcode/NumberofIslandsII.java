package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberofIslandsII {
    Node[][] dict;
    int count;

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ret = new ArrayList<>();
        this.dict = new Node[m][n];
        this.count = 0;

        for (int x = 0; x < positions.length; x++) {
            int i = positions[x][1];
            int j = positions[x][0];

            if (dict[j][i] != null) {
                ret.add(this.count);
                continue;
            }

            Node left = null;
            if (i > 0) {
                left = dict[j][i - 1];
            }
            Node right = null;
            if (i < n - 1) {
                right = dict[j][i + 1];
            }
            Node top = null;
            if (j > 0) {
                top = dict[j - 1][i];
            }
            Node bot = null;
            if (j < m - 1) {
                bot = dict[j + 1][i];
            }

            Node node = new Node(null, 0);
            this.count++;

            merge(merge(merge(merge(left, right), top), bot), node);

            dict[j][i] = node;
            ret.add(this.count);
        }
        return ret;
    }

    // return new root, n1, n2 disjoint not null;
    public Node merge(Node n1, Node n2) {
        Node r1 = getRoot(n1);
        Node r2 = getRoot(n2);

        if (n1 == null) {
            return r2;
        }
        if (n2 == null) {
            return r1;
        }

        if (r1 == r2) {
            return r1;
        }

        this.count--;
        if (r1.rank >= r2.rank) {
            if (r1.rank == r2.rank) {
                r1.rank++;
            }
            r2.parent = r1;
            return r1;
        } else {
            r1.parent = r2;
            return r2;
        }
    }

    public Node getRoot(Node n) {
        if (n == null) {
            return null;
        }
        if (n.parent == n) {
            return n;
        }
        return n.parent = getRoot(n.parent);
    }

    public class Node {
        Node parent;
        int rank;

        public Node(Node parent, int rank) {
            this.parent = parent;
            if (this.parent == null) {
                this.parent = this;
            }
            this.rank = rank;
        }
    }

    @Test
    public void test() {
        int m = 3;
        int n = 3;

        int[][] positions = new int[][]{{0, 0}, {0, 1}, {1, 2},{2, 1}, {1, 0}, {0,0},{2,2},{1,1},{0,1}};
        NumberofIslandsII sol = new NumberofIslandsII();
        List<Integer> list = sol.numIslands2(m, n, positions);
        System.out.println(list);
    }

}
