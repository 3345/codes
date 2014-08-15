package Semaphore;

import org.junit.Test;

/**
 * Created by yfu on 8/7/14.
 */
public class SemaphoreTest {
    @Test
    public void test() throws InterruptedException {
        final Semaphore semaphore = new Semaphore(4);
        Thread t1 = new Thread(new Inc(semaphore));
        Thread t2 = new Thread(new Dec(semaphore));
        Thread t3 = new Thread(new Dec(semaphore));
        Thread t4 = new Thread(new Inc(semaphore));
        t1.start();t2.start();t3.start();t4.start();
        t1.join();t2.join();t3.join();t4.join();

    }
}
