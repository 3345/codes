package ch3;

import dataStructure.MyStack;
import org.junit.Test;

public class p3_6 {
    public static MyStack<Integer> sortStack(MyStack<Integer> stack) throws Exception {
        MyStack<Integer> buffer = new MyStack<Integer>();

        while (!stack.isEmpty()) {
            if (buffer.isEmpty() || buffer.peek() >= stack.peek()) {
                buffer.push(stack.pop());
            } else {
                Integer holder = stack.pop();
                while (!buffer.isEmpty() && buffer.peek() < holder) {
                    stack.push(buffer.pop());
                }
                buffer.push(holder);
            }
        }

        return buffer;
    }

    @Test
    public void t1() throws Exception {
        MyStack<Integer> stack = new MyStack<Integer>();
        stack.push(5);
        stack.push(3);
        stack.push(2);
        stack.push(2);
        stack.push(4);
        stack.push(1);
        stack.push(10);

        stack = sortStack(stack);

        stack.print();

    }

}
