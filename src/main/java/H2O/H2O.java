package H2O;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yfu on 8/3/14.
 */
public class H2O {
    BlockingQueue<Object> hq = new LinkedBlockingQueue<Object>(2);
    BlockingQueue<Object> oq = new LinkedBlockingQueue<Object>(1);
    Lock lock = new ReentrantLock();

    public void h() throws InterruptedException {
        Object mon = new Object();
        lock.lock();
        if (!hq.offer(mon)) {
            lock.unlock();
            hq.put(mon);
        }
        System.out.println("add h " + Thread.currentThread() + " time " + System.currentTimeMillis());
        if (hq.size() == 2 && oq.size() == 1) {
            h2o();
            lock.unlock();
        }
        else {
            lock.unlock();
            synchronized (mon) {
                System.out.println("about sleep h " + Thread.currentThread() + " time " + System.currentTimeMillis());

                mon.wait();
            }
        }
        System.out.println("wake h " + Thread.currentThread() + " time " + System.currentTimeMillis());
    }

    public  void o() throws InterruptedException {
        Object mon = new Object();
        lock.lock();
        if (!oq.offer(mon)) {
            lock.unlock();
            oq.put(mon);
        }

        System.out.println("add o " + Thread.currentThread() + " time " + System.currentTimeMillis());
        if (hq.size() == 2 && oq.size() == 1) {
            h2o();
            lock.unlock();
        }
        else {
            lock.unlock();
            synchronized (mon) {
                System.out.println("about sleep o " + Thread.currentThread() + " time " + System.currentTimeMillis());

                mon.wait();
            }
        }
        System.out.println("wake o " + Thread.currentThread() + " time " + System.currentTimeMillis());

    }

    public void h2o() throws InterruptedException{
        if (hq.size() == 2 && oq.size() == 1) {
            Object o = oq.poll();
            Object h1 = hq.poll();
            Object h2 = hq.poll();


            synchronized (o) {
                o.notify();
            }
            synchronized (h1) {
                h1.notify();
            }
            synchronized (h2) {
                h2.notify();
            }
            System.out.println("h2o" + " time " + System.currentTimeMillis());
        }
    }

}
