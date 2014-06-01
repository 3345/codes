package ch2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class p2_2 {
    public ArrayList nToLastElements(LinkedList linkedList, int n) {
        ListIterator iter1 = linkedList.listIterator();
        ListIterator iter2 = linkedList.listIterator();
        for (int i = 0; i < n; i++) {
            if (iter2.hasNext())
                iter2.next();
            else
                return null;
        }
        Object obj;
        while (iter2.hasNext()) {
            iter1.next();
            iter2.next();
        }
        ArrayList out = new ArrayList();
        while (iter1.hasNext()) {
            obj = iter1.next();
            out.add(obj);
        }
        return out;
    }

    @Test
    public void t1() {
        LinkedList in = new LinkedList(Arrays.asList(1,2,3,4,5,6,7,8,9,0));
        ArrayList out = nToLastElements(in, 10);
        System.out.println(out);
    }
}
