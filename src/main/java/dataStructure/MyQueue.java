package dataStructure;

public class MyQueue <T>{
    public MyNode first, last;

    public void enqueue(T data) {
        MyNode<T> node = new MyNode<T>(data);
        if (first != null) {
            last.next = node;
            last = node;
        } else {
            first = node;
            last = node;
        }
    }

    public MyNode dequeue() {
        if (first != null) {
            MyNode oldFirst = first;
            first = first.next;
            return oldFirst;
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }
}
