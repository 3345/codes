package NonBlockingQueue;

/**
 * Created by yfu on 8/2/14.
 */
public class Node<T> {
    public T val;
    public Node<T> next;

    public Node() {};
    public Node(T val) {
        this.val = val;
    }
}
