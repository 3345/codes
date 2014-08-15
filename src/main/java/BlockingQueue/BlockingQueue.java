package BlockingQueue;

/**
 * Created by yfu on 8/8/14.
 */
public class BlockingQueue {
    private static final int SIZE = 5;
    private volatile int[] a = new int[SIZE];
    private volatile int count = 0;
    private volatile int front = 0;

    /**
     * put element in queue, block if queue if full
     * @param i element to put in queue
     */
    public synchronized void put(int i) {
        while (count == SIZE) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        a[(front + count)%SIZE] = i;
        count ++;
        System.out.println("put: " + i);
        notifyAll();
    }

    /**
     * take first element out of queue, block if queue is empty
     * @return element popped out of queue
     */
    public synchronized int take() {
        while (count == 0) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        int result = a[front];
        front = (front + 1)%SIZE;
        count --;
        System.out.println("take: " + result);
        notifyAll();
        return result;
    }

}

class Putter implements Runnable {
    BlockingQueue q;

    public Putter(BlockingQueue q) {
        this.q = q;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i ++) {
            q.put(i);
        }
    }
}

class Taker implements Runnable {
    BlockingQueue q;

    public Taker(BlockingQueue q) {
        this.q = q;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i ++) {
            q.take();
        }
    }
}