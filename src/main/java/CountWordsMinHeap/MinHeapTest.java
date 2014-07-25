package CountWordsMinHeap;

import org.junit.Test;

import java.util.List;


public class MinHeapTest {
    @Test
    public void dump_shouldReturnNWordOfHighestFrequency() {
        MinHeap minHeap = new MinHeap(4);
        minHeap.add("three", 3);
        minHeap.add("ten", 10);
        minHeap.add("one", 1);
        minHeap.add("hundred", 100);
        minHeap.add("fifty", 50);
        minHeap.add("fiftyII", 50);
        minHeap.add("oneII", 1);

        List<String> result = minHeap.dump();
        System.out.println(result);
    }

}
