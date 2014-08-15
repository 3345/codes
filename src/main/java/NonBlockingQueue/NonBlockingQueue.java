package NonBlockingQueue;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by yfu on 8/2/14.
 */
public class NonBlockingQueue<T> {
    Node<T> head;
    Node<T> tail;

    ConcurrentLinkedQueue queue;
    public void enqueue(T val) {
        Node node = new Node(val);
        Node<T> t;
        while (true) {
            t = tail;
            Node<T> next = t.next;
            if (t == tail) {
                if (next == null) {
                    if (new AtomicReference<Node<T>>(t.next).compareAndSet(next, node))
                        break;
                } else {
                    new AtomicReference<Node<T>>(tail).compareAndSet(t, next);
                }
            }
        }
        new AtomicReference<Node<T>>(tail).compareAndSet(t, node);
    }

    public T dequeue() {
        return null;
    }
}
