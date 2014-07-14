package others;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<Integer>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                numbers.push(numbers.pop() + numbers.pop());
            } else if ("-".equals(token)) {
                numbers.push(- numbers.pop() + numbers.pop());
            } else if("*".equals(token)) {
                numbers.push(numbers.pop() * numbers.pop());
            } else if ("/".equals(token)) {
                int second = numbers.pop();
                int first = numbers.pop();
                numbers.push(first/second);
            } else {
                numbers.push(Integer.parseInt(token));
            }
        }
        return numbers.pop();
    }

    @Test
    public void t1() {
        String [] a = {"0", "3", "/"};
        System.out.println(evalRPN(a));
    }

}
