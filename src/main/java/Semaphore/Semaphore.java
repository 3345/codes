package Semaphore;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Created by yfu on 8/7/14.
 */
public class Semaphore {
    volatile int i;
    Lock lock = new ReentrantLock();

    public Semaphore(int i) {
        this.i = i;
    }

    public void increment() {
        lock.lock();
        i ++;
        System.out.println("i");
        lock.unlock();
    }

    public synchronized void decrement() throws InterruptedException {
        while (i == 0) {}
        lock.lock();
        i --;
        System.out.println("d");
        lock.unlock();
    }





}

class Inc implements Runnable {
    private Semaphore semaphore;

    public Inc(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i ++) {
            semaphore.increment();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Dec implements Runnable {
    private Semaphore semaphore;

    public Dec(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i ++) {
            try {
                semaphore.decrement();
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
