package dataStructure;

public class MyNode<T> {
    public T data;
    public MyNode next;

    public MyNode() {
        data = null;
        next = null;
    }

    public MyNode(T d) {
        data = d;
        next = null;
    }

    public boolean hasNext() {
        return this.next != null;
    }
}
