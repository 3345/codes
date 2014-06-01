package dataStructure;

public class MyStack<T> {
    public MyNode<T> top;
    public int size;

    public T pop() {
        if (top == null) {
            return null;
        }
        T data = top.data;
        top = top.next;
        size --;
        return data;
    }

    public void push(T data) throws Exception {
        MyNode<T> newTop = new MyNode<T>(data);
        newTop.next = top;
        top = newTop;
        size ++;
    }

    public T peek() {
        if (top == null)
            return null;
        return top.data;
    }

    public void print() {
        if (top == null)
            return;
        MyNode<T> node = top;
        System.out.print(node.data + " ");
        while (node.hasNext()) {
            System.out.print(node.next.data + " ");
            node = node.next;
        }
        System.out.print("\n");
    }

    public boolean isEmpty() {
        return this.top == null;
    }
}
