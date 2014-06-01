package ch2;

import org.junit.Test;

import java.util.*;

public class p2_1 {
    List list = Arrays.asList(1, 2, 3, 3, 4, 4);
    LinkedList in = new LinkedList(list);

    public LinkedList removeDuplicates1(LinkedList linkedList) {
        Set set = new HashSet();
        Iterator iter = linkedList.iterator();
        while (iter.hasNext()) {
            Object i = iter.next();
            if (set.contains(i))
                iter.remove();
            else
                set.add(i);
        }
        return linkedList;
    }

    //no memory buffer
    public LinkedList removeDuplicates2(LinkedList linkedList) {
        for (int i = 0; i < linkedList.size() - 1; i++) {
            Object obj = linkedList.get(i);
            for (int j = i + 1; j < linkedList.size(); j++) {
                if (obj.equals(linkedList.get(j)))
                    linkedList.remove(j);
            }
        }
        return linkedList;
    }

    @Test
    public void t1() {
        LinkedList out = removeDuplicates1(in);
        System.out.println(out);
    }

    @Test
    public void t2() {
        LinkedList out = removeDuplicates2(in);
        System.out.println(out);
    }
}
