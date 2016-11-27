package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by fyl on 11/26/16.
 */
public class CopyListWithRandomPointer {

    public class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>(); //<orig , clone>

        if (head == null) {
            return null;
        }

        RandomListNode c = head;
        RandomListNode prev = null;



        while (c != null) {
            RandomListNode n;
            RandomListNode origRandom = c.random;

            if (!map.containsKey(c)) {
                n = new RandomListNode(c.label);
                map.put(c, n);

            } else {
                n = map.get(c);
            }

            if (origRandom != null) {
                if (!map.containsKey(origRandom)) {
                    RandomListNode nr = new RandomListNode(origRandom.label);
                    n.random = nr;
                    map.put(origRandom, nr);
                } else {
                    n.random = map.get(origRandom);
                }
            }

            if (prev != null) {
                prev.next = n;
            }

            prev = n;
            c = c.next;
        }

        return map.get(head);
    }
}
