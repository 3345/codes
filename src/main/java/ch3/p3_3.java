package ch3;

import dataStructure.MyNode;
import dataStructure.MyStack;
import org.junit.Test;

import java.util.ArrayList;

public class p3_3 {
    public class StackWithCapacity<T> extends MyStack<T> {
        int capacity;
        int size;

        public StackWithCapacity(int capacity) {
            this.capacity = capacity;
        }

        @Override
        public void push(T data) throws Exception {
            if (size < capacity) {
                super.push(data);
                size ++;
            } else {
                throw new Exception("exceeding stack capacity");
            }
        }

        @Override
        public T pop() {
            if (size > 0) {
                size --;
                return super.pop();
            } else {
                return null;
            }
        }

        public T removeBottom() {
            MyNode<T> node = top;
            T data;
            if (node == null)
                return null;

            size--;

            if (!node.hasNext()) {
                data = top.data;
                top = null;
                return data;
            }

            while (node.next.hasNext()) {
                node = node.next;
            }
            data = (T)node.next.data;
            node.next = null;
            return data;
        }
    }

    public class SetOfStacks<T> {
        int capacity;
        ArrayList<StackWithCapacity<T>> stacks = new ArrayList<StackWithCapacity<T>>();

        public SetOfStacks(int capacity){
            this.capacity = capacity;
        }

        public void push (T data) throws Exception{
            if (stacks.size() == 0)
                stacks.add(new StackWithCapacity<T>(capacity));
            StackWithCapacity<T> latestStack = stacks.get(stacks.size() - 1);
            try {
                latestStack.push(data);
            } catch (Exception e) {
                StackWithCapacity<T> newStack = new StackWithCapacity<T>(capacity);
                newStack.push(data);
                stacks.add(newStack);
            }
        }

        public T pop() {
            if (stacks.size() == 0)
                return null;
            T data;
            StackWithCapacity<T> latestStack = stacks.get(stacks.size() - 1);
            data = latestStack.pop();
            if (latestStack.size == 0)
                stacks.remove(latestStack);
            return data;
        }

        public T pop(int stackNum) throws Exception{
            if (stackNum < 0 || stackNum > stacks.size() - 1)
                throw new Exception(String.format("stack number invalid, should be 0 to %s", stacks.size() - 1));
            if (stackNum == stacks.size() -1)
                return pop();
            T data = stacks.get(stackNum).pop();
            for (int i = stackNum; i < stacks.size() - 1; i ++) {
                stacks.get(i).push(stacks.get(i + 1).removeBottom());
                if (stacks.get(i + 1).size == 0) {
                    stacks.remove(i + 1);
                    break;
                }
            }
            return data;
        }

        public void print() {
            for (StackWithCapacity stack : stacks) {
                stack.print();
            }
            System.out.print("\n");
        }
    }

    @Test
    public void t1() throws Exception {
        SetOfStacks<Integer> setOfStacks = new SetOfStacks<Integer>(3);
        for (int i = 1; i < 10; i ++) {
            setOfStacks.push(i);
        }
        setOfStacks.print();

        for (int i = 0; i < 5; i ++ ) {
            setOfStacks.pop();
        }
        setOfStacks.print();

        setOfStacks.pop(0);
        setOfStacks.print();
    }

    @Test
    public void t2() throws Exception {
        SetOfStacks<Integer> setOfStacks = new SetOfStacks<Integer>(3);
        for (int i = 1; i < 10; i ++) {
            setOfStacks.push(i);
        }
        setOfStacks.print();

        setOfStacks.pop(0);
        setOfStacks.print();

        setOfStacks.pop(1);
        setOfStacks.print();

        setOfStacks.pop(0);
        setOfStacks.print();
    }

    @Test
    public void t3() throws Exception {
        SetOfStacks<Integer> setOfStacks = new SetOfStacks<Integer>(1);
        for (int i = 1; i < 4; i ++) {
            setOfStacks.push(i);
        }
        setOfStacks.print();

        setOfStacks.pop(0);
        setOfStacks.print();

        setOfStacks.pop(1);
        setOfStacks.print();
    }
}
