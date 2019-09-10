import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;

public class Scheduler implements Runnable {
    PriorityQueue<ScheduleUnit> pq;
    Semaphore semaphore = new Semaphore(1);

    public Scheduler() {
        this.pq = new PriorityQueue<>();
    }

    public synchronized boolean schedule(int mill, Runnable r) {
        if (mill < 0) {
            return false;
        }
        long ts = System.currentTimeMillis() + mill;
        if (pq.offer(new ScheduleUnit(ts, r, this.semaphore))) {
            this.notify();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public synchronized void run() {
        try {
            while (true) {
                if (pq.size() == 0) {
                    this.wait();
                }
                ScheduleUnit unit = pq.peek();
                long timeDiff = unit.timestamp - System.currentTimeMillis();
                if (timeDiff <= 0) {
                    pq.poll();
                    new Thread(unit.runnable).start();
                } else {
                    this.wait(timeDiff);
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private class ScheduleUnit implements Comparable {
        long timestamp;
        MyRunnable runnable;

        public ScheduleUnit(long ts, Runnable r, Semaphore s) {
            this.timestamp = ts;
            this.runnable = new MyRunnable(s, r);
        }

        @Override
        public int compareTo(Object o) {
            ScheduleUnit that = (ScheduleUnit) o;
            if (this.timestamp == that.timestamp) return 0;
            return this.timestamp - that.timestamp > 0 ? 1 : -1;
        }
    }

    private class MyRunnable implements Runnable {
        Semaphore semaphore;
        Runnable r;
        public MyRunnable(Semaphore s, Runnable r) {
            this.semaphore = s;
            this.r = r;
        }

        @Override
        public void run() {
            try {
                this.semaphore.acquire();
                r.run();
                this.semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] arg) throws InterruptedException {
        Scheduler sch = new Scheduler();
        new Thread(sch).start();
        Runnable a = () -> {
            try {
                Thread.sleep(2000);
                System.out.println("a" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable b = () -> System.out.println("b" + System.currentTimeMillis());

        sch.schedule(0, a);
        Thread.sleep(1);
        sch.schedule(0, b);
    }

}