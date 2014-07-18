package CountWordsMaxHeap;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class MaxHeapTest {
    @Test
    public void remove_shouldReturnWordOfHighestFrequency() {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.add("three", 3);
        maxHeap.add("ten", 10);
        maxHeap.add("one", 1);
        maxHeap.add("hundred", 100);
        maxHeap.add("fifty", 50);
        maxHeap.add("fiftyII", 50);
        maxHeap.add("oneII", 1);

        assertEquals("hundred", maxHeap.remove());
        String fifty = maxHeap.remove();
        String fifty2 = maxHeap.remove();
        assertTrue("fifty".equals(fifty) || "fiftyII".equals(fifty));
        assertTrue("fifty".equals(fifty2) || "fiftyII".equals(fifty2));
        assertEquals("ten", maxHeap.remove());
        assertEquals("three", maxHeap.remove());
        String one = maxHeap.remove();
        String one2 = maxHeap.remove();
        assertTrue("one".equals(one) || "oneII".equals(one));
        assertTrue("one".equals(one2) || "oneII".equals(one2));
    }
}
