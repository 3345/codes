import java.util.HashMap;
import java.util.Map;

public class Cache<T> {
    private class ListNode<T> {
        ListNode prev;
        ListNode next;
        T key;
        int val;

        long exp;

        public ListNode(T key, int val, long exp) {
            this.key = key;
            this.exp = exp;
            this.val = val;
        }

        public ListNode() {}

        //a,b,c
        public void remove() {
            this.prev.next  = this.next;
            this.next.prev = this.prev;
        }

        public void addBefore(ListNode n) {
            ListNode before = this.prev;
            before.next = n;
            n.prev = before;
            n.next = this;
            this.prev = n;
        }
    }

    ListNode head;
    ListNode tail;
    Map<T, ListNode> map = new HashMap<>();
    int sum;

    public Cache() {
        this.head = new ListNode();
        this.tail = new ListNode();
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.sum = 0;
    }

    public void put(T key, int val, long duration) {
        this.prune();
        if (map.containsKey(key)) {
            map.get(key).remove();
            sum -= map.get(key).val;
        }
        ListNode<T> n = new ListNode<>(key, val, System.currentTimeMillis() + duration);
        this.tail.addBefore(n);
        this.map.put(key, n);
        sum += val;
    }

    public Integer get(T key) {
        this.prune();
        if (map.containsKey(key)) {
            return map.get(key).val;
        } else {
            return null;
        }
    }

    public double avg() {
        this.prune();
        if (map.size() == 0) return 0;
        return ((double)this.sum / map.size());
    }

    private void prune() {
        ListNode cur = this.head.next;
        long now = System.currentTimeMillis();
        while (cur != tail) {
            if (cur.exp < now) {
                ListNode next = cur.next;
                cur.remove();
                map.remove(cur.key);
                sum -= cur.val;
                cur = next;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        try {
            Cache<String> cache = new Cache<>();
            cache.put("a", 1, 1000);
            cache.put("a", 1, 2000);
            cache.put("b", 2, 2000);
            cache.put("c", 3, 4000);

            Thread.sleep(3001);
            System.out.println(cache.get("a"));
            System.out.println(cache.avg());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}











