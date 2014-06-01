package ch4;

import dataStructure.MyTreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p4_8 {
    class Path {
        int currentSum;
        ArrayList<Integer> currentPath = new ArrayList<Integer>();

        public Path(int sum, ArrayList<Integer> currentPath) {
            currentSum = sum;
            this.currentPath = currentPath;
        }

        public Path(int sum) {
            currentSum = sum;
            currentPath.add(sum);
        }

    }

    public void sumPath(int sum, MyTreeNode<Integer> root, ArrayList<Path> paths, List<List<Integer>> result) {
        for (Path path : paths) {
            path.currentSum += root.data;
            path.currentPath.add(root.data);

            if (path.currentSum == sum) {
                result.add(path.currentPath);
            }

        }

        paths.add(new Path(root.data));


        if (root.data == sum)
            result.add(new ArrayList<Integer>(Arrays.asList(sum)));

        ArrayList<Path> newPaths1 = new ArrayList<Path>();
        ArrayList<Path> newPaths2 = new ArrayList<Path>();

        for (Path path : paths) {
            ArrayList<Integer> currentPath1 = (ArrayList<Integer>)path.currentPath.clone();
            ArrayList<Integer> currentPath2 = (ArrayList<Integer>)path.currentPath.clone();
            newPaths1.add(new Path(path.currentSum, currentPath1));
            newPaths2.add(new Path(path.currentSum, currentPath2));

        }

        if (root.hasLeft()) {
            sumPath(sum, root.getLeft(), newPaths1, result);
        }

        if (root.hasRight()) {
            sumPath(sum, root.getRight(), newPaths2, result);
        }


    }

    public List<List<Integer>> sumPath(int sum, MyTreeNode<Integer> root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        sumPath(sum, root, new ArrayList<Path>(), result);
        return result;
    }

    @Test
    public void t1() {
        MyTreeNode<Integer> node0 = new MyTreeNode<Integer>(0);
        MyTreeNode<Integer> node1 = new MyTreeNode<Integer>(1);
        MyTreeNode<Integer> node2 = new MyTreeNode<Integer>(2);
        MyTreeNode<Integer> node3 = new MyTreeNode<Integer>(3);
        MyTreeNode<Integer> node4 = new MyTreeNode<Integer>(4);
        MyTreeNode<Integer> node5 = new MyTreeNode<Integer>(5);
        MyTreeNode<Integer> node6 = new MyTreeNode<Integer>(6);
        MyTreeNode<Integer> node7 = new MyTreeNode<Integer>(7);
        MyTreeNode<Integer> node8 = new MyTreeNode<Integer>(8);
        MyTreeNode<Integer> node9 = new MyTreeNode<Integer>(9);

        node0.addChildNodes(node1, node2);
        node1.addChildNodes(node3, node4);
        node2.addChildNodes(node5, node6);
        node3.addChildNodes(node7, node8);
        node5.addChildNodes(node9);

        /*
             0
          1    2
        3  4  5 6
       7 8    9
        */

        List<List<Integer>> result = sumPath(11, node0);
        for (List<Integer> path : result) {
            for (Integer i : path) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }
    }


}


