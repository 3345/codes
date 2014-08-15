package BlockingQueue;

import org.junit.Test;

public class BlockingQueueTest {
    @Test
    public void test_q() {
        BlockingQueue q = new BlockingQueue();
        q.put(1);
        q.put(2);
        q.put(3);
        q.take();
        q.take();
        q.put(4);
        q.take();
        q.take();
        q.take();
    }

    @Test
    public void test() throws Exception {
        BlockingQueue q = new BlockingQueue();

        Thread t1 = new Thread(new Putter(q));
        Thread t2 = new Thread(new Putter(q));
        Thread t3 = new Thread(new Taker(q));
        Thread t4 = new Thread(new Taker(q));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
    }

}
