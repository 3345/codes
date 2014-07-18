package CountWordsMinHeap;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *  a min heap maintaining a max capacity to avoid unnecessary re-heap
 */
public class MinHeap {
    PriorityQueue<Node> heap;
    int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        heap = new PriorityQueue<Node>(new NodeComparator());
    }

    /**
     *  only add to heap if input frequency is greater than current minimum
     */
    public void add(String word, int frequency) {
        if (heap.size() < capacity)
            heap.add(new Node(word, frequency));
        else {
            Node min = heap.peek();
            if (min.frequency < frequency) {
                heap.remove();
                heap.add(new Node(word, frequency));
            }
        }
    }

    // for test only
    public void add(Node node) {
        if (heap.size() < capacity)
            heap.add(node);
        else {
            Node min = heap.peek();
            if (min.frequency < node.frequency) {
                heap.remove();
                heap.add(node);
            }
        }
    }

    /**
     *  dump heap elements into a list in descending(frequency) order
     */
    public List<String> dump() {
        LinkedList<String> list = new LinkedList<String>();
        while (!heap.isEmpty()) {
            list.addFirst(heap.remove().word);
        }
        return list;
    }

    public class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node x, Node y)
        {
            if (x.frequency > y.frequency)
            {
                return 1;
            }
            if (x.frequency < y.frequency)
            {
                return -1;
            }
            return 0;
        }
    }
}
