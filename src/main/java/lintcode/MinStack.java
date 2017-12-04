package lintcode;

import java.util.Stack;

/**
 * Created by fyl on 12/3/17.
 */
public class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public MinStack() {
        // do intialization if necessary
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        stack.push(number);
        if (min.size() == 0) {
            min.push(number);
            return;
        }
        if (min.peek() > number) {
            min.push(number);
        } else {
            min.push(min.peek());
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        min.pop();
        return stack.pop();
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return min.peek();
    }
}
