package ch3;

import dataStructure.MyStack;
import org.junit.Test;

public class p3_5 {
    public class QueueWithTwoStacks<T> {
        MyStack<T> stack1 = new MyStack<T>();
        MyStack<T> stack2 = new MyStack<T>();

        public void enqueue(T data) throws Exception {
            stack1.push(data);
        }

        public T dequeue() throws Exception {
            while (stack1.top != null) {
                stack2.push(stack1.pop());
            }

            T data = stack2.pop();

            while (stack2.top != null) {
                stack1.push(stack2.pop());
            }

            return data;
        }

        public T peek() throws Exception {
            return stack1.top.data;
        }

        public void print() throws Exception {
            stack1.print();
        }
    }

    @Test
    public void t1() throws Exception {
        QueueWithTwoStacks<Integer> q = new QueueWithTwoStacks<Integer>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.print();

        q.dequeue();
        q.dequeue();
        q.print();

        q.enqueue(4);
        q.enqueue(5);
        q.print();

        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.print();
    }
}
