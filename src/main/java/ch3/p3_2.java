package ch3;

import dataStructure.MyStack;
import org.junit.Test;

public class p3_2 {
    public class StackWithMin extends MyStack<Integer> {
        MyStack<Integer> minStack = new MyStack<Integer>();

        @Override
        public void push (Integer i) throws Exception {
            if (i <= min())
                minStack.push(i);
            super.push(i);
        }

        @Override
        public Integer pop() {
            if (peek() == min())
                minStack.pop();
            return super.pop();
        }

        public Integer min() {
            if (minStack.peek() == null)
                return Integer.MAX_VALUE;
            return minStack.peek();
        }
    }

    @Test
    public void t1() throws Exception {
        StackWithMin stackWithMin = new StackWithMin();
        stackWithMin.push(10);
        stackWithMin.push(12);
        stackWithMin.push(9);
        stackWithMin.push(5);
        stackWithMin.push(8);
        System.out.println(stackWithMin.min());
        stackWithMin.pop();
        System.out.println(stackWithMin.min());
        stackWithMin.pop();
        System.out.println(stackWithMin.min());
        stackWithMin.pop();
        System.out.println(stackWithMin.min());
        stackWithMin.pop();
        System.out.println(stackWithMin.min());
        stackWithMin.pop();
        System.out.println(stackWithMin.min());
        stackWithMin.pop();
        System.out.println(stackWithMin.min());
    }
}
