package lintcode;

import java.util.*;

/**
 * Created by fyl on 7/23/19.
 */
public class MergeKSortedArrays {
    public int[] mergekSortedArrays(int[][] arrays) {
        // write your code here
        if (arrays == null) {
            return new int[]{};
        }
        //Queue<Integer> list = new LinkedList<>();

        int totalLen = 0;
        Queue<QNode> heap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        for (int i = 0; i < arrays.length; i++) {
            int[] a = arrays[i];
            if (a.length == 0) {
                continue;
            }
            totalLen += a.length;
            heap.add(new QNode(a[0], i, 0));
        }
        int[] result = new int[totalLen];
        int resultIndex = 0;

        while (!heap.isEmpty()) {
            QNode node = heap.poll();
            result[resultIndex] = node.val;
            resultIndex++;
            if (node.position < arrays[node.index].length - 1) {
                heap.offer(new QNode(arrays[node.index][node.position+1], node.index, node.position+1));
            }
        }

        return result;
    }

    public class QNode {
        int val;
        int index;
        int position;
        QNode(int val, int index, int position) {
            this.val=val;
            this.index=index;
            this.position=position;
        }
    }
}
