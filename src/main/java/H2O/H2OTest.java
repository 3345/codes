package H2O;

import org.junit.Test;

/**
 * Created by yfu on 8/3/14.
 */
public class H2OTest {
    @Test
    public void test() throws InterruptedException {
        H2O obj = new H2O();
        Thread h1 = new Thread(new addH(obj));
        Thread h2 = new Thread(new addH(obj));
        Thread h3 = new Thread(new addH(obj));
        Thread h4 = new Thread(new addH(obj));
        Thread h5 = new Thread(new addH(obj));
        Thread h6 = new Thread(new addH(obj));

        Thread o = new Thread(new addO(obj));
        Thread o1 = new Thread(new addO(obj));
        Thread o2 = new Thread(new addO(obj));

        h1.start();h2.start();
        h3.start(); h4.start();
        o.start();
        o1.start();
        o2.start();

        h5.start();h6.start();

        h1.join();
        h2.join();
        h3.join();
        h4.join();
        h5.join();h6.join();
        o.join();
        o1.join();
        o2.join();

    }

    public class addH implements Runnable {
        H2O obj;

        public addH(H2O obj) {
            this.obj = obj;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1; i++) {
                try {
                    obj.h();
                   // Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class addO implements Runnable {
        H2O obj;

        public addO(H2O obj) {
            this.obj = obj;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1; i++) {
                try {
                    obj.o();
                  //  Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
