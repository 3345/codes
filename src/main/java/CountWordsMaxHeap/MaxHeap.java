package CountWordsMaxHeap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxHeap {
    PriorityQueue<Node> heap;

    public MaxHeap() {
        heap = new PriorityQueue<Node>(new NodeComparator());
    }
    
    public void add(String word, int frequency) {
        heap.add(new Node(word, frequency));
    }

    public String remove() {
        return heap.remove().word;
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public class Node {
        String word;
        int frequency;
        public Node(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }
    }

    public class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node x, Node y)
        {
            if (x.frequency < y.frequency)
            {
                return 1;
            }
            if (x.frequency > y.frequency )
            {
                return -1;
            }
            return 0;
        }
    }
}
