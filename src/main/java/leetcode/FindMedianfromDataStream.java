package leetcode;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by fyl on 1/7/18.
 */
public class FindMedianfromDataStream {
    public class MedianFinder {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        public MedianFinder() {


        }

        public void addNum(int num) {
            if (minHeap.size() == 0 || minHeap.peek() <= num) {
                minHeap.offer(num);
            } else {
                maxHeap.offer(num);
            }

            if (Math.abs(minHeap.size() - maxHeap.size()) > 1) {
                if (minHeap.size() > maxHeap.size()) {
                    maxHeap.offer(minHeap.poll());
                } else {
                    minHeap.offer(maxHeap.poll());
                }
            }
        }

        public double findMedian() {
            if (minHeap.size() == maxHeap.size()) {
                return (minHeap.peek() + maxHeap.peek()) / 2D;
            }

            return minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek();
        }

    }

    @Test
    public void test() {
        MedianFinder mf = new MedianFinder();
        mf.addNum(-1); mf.addNum(-2); mf.addNum(-3);
        mf.findMedian();
    }
}
