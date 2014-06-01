package ch3;

import dataStructure.MyStack;
import org.junit.Test;

import java.util.ArrayList;

public class p3_4 {
    public class Hanoi {
        int numOfDisks;
        Rod rod1 = new Rod("rod1");
        Rod rod2 = new Rod("rod2");
        Rod rod3 = new Rod("rod3");
        ArrayList<String> procedure = new ArrayList<String>();

        public class Rod extends MyStack<Integer> {
            public String name;

            public Rod(String name) {
                this.name = name;
            }
        }

        public Hanoi (int numOfDisks) throws Exception {
            this.numOfDisks = numOfDisks;

            for (int i = numOfDisks; i > 0; i --) {
                rod1.push(i);
            }
        }

        public void move (Rod from, Rod to, Rod rest, int num) throws Exception {
            if (num == 1) {
                Integer disk = (Integer)from.pop();
                to.push(disk);
                procedure.add(String.format("move disk %d from %s to %s", disk, from.name, rest.name));

                return;
            }

            move(from, rest, to, num - 1);

            Integer disk = (Integer)from.pop();
            to.push(disk);
            procedure.add(String.format("move disk%d from %s to %s", disk, from.name, to.name));

            move(rest, to, from, num - 1);
        }

        public void print () {
            for (String s : procedure) {
                System.out.println(s);
            }
        }
    }

    @Test
    public void t1() throws Exception {
        Hanoi hanoi = new Hanoi(5);
        hanoi.move(hanoi.rod1, hanoi.rod3, hanoi.rod2, 5);
        hanoi.print();
    }
}
