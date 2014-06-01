package ch3;

import org.junit.Test;

import java.util.Arrays;

public class p3_1 {
    public class ThreeStackArray {
        int size;
        Object [] buffer;
        int [] stackPointers = new int[3];

        public ThreeStackArray(int size) {
            this.size = size;
            buffer = new Object[3*size];
            stackPointers [1]= size;
            stackPointers [2] = 2*size;
        }

        public void push (int stackNum, Object data) throws IndexOutOfBoundsException{
            if (this.sizeOf(stackNum) >= this.size) {
                throw new IndexOutOfBoundsException();
            } else {
                buffer[stackPointers[stackNum]] = data;
                stackPointers[stackNum]++;
            }
        }

        public Object pop (int stackNum) {
            if (this.sizeOf(stackNum) == 0) {
                return null;
            } else {
                int currentPointer = stackPointers[stackNum];
                stackPointers[stackNum]--;
                return buffer[currentPointer - 1];
            }
        }

        public int sizeOf(int stackNum) {
            return stackPointers[stackNum] - stackNum*size;
        }

        public void print() {
            System.out.println(Arrays.toString(buffer));
            System.out.println(Arrays.toString(stackPointers));
        }
    }

    @Test
    public void t1() throws Exception {
        ThreeStackArray stacks = new ThreeStackArray(3);
        stacks.push(0, "0a");
        stacks.push(0, "0b");
        stacks.push(0, "0c");
        stacks.push(1, "1a");
        stacks.push(1, "1b");
        stacks.push(1, "1c");
        stacks.push(2, "2a");
        stacks.push(2, "2b");
        stacks.push(2, "2c");
        stacks.print();
        System.out.println(stacks.pop(0));
        System.out.println(stacks.pop(1));
        stacks.print();
        System.out.println(stacks.pop(0));
        System.out.println(stacks.pop(1));
        System.out.println(stacks.pop(0));
        System.out.println(stacks.pop(1));
        stacks.print();
        stacks.push(0, "x");
        stacks.push(0, "x");
        stacks.push(0, "x");
        stacks.push(1, "x");
        stacks.push(1, "x");
        stacks.push(1, "x");
        stacks.print();
    }
}
