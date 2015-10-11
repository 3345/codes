package leetcode;

import org.junit.Test;

import java.util.Stack;

public class ReversePolishNotation {
    public static int evalRPN(String[] tokens) throws InvalidInput {
        if (null == tokens || tokens.length == 0) {
            return 0;
        }

        Stack<Integer> numbers = new Stack<Integer>();


        for (String token : tokens) {
            if (isOperator(token)) {
                if (numbers.size() < 2) {
                    throw new InvalidInput("not enough operands");
                }

                int second = numbers.pop();
                int first = numbers.pop();

                numbers.push(doMath(first, second, token));

            } else {
                if (!isInteger(token)) {
                    throw new InvalidInput(String.format("cannot recognize token '%s'", token));
                }

                numbers.push(Integer.parseInt(token));
            }
        }

        if (numbers.size() > 1) {
            throw new InvalidInput("not enough operators");
        }


        return numbers.pop();
    }

    private static boolean isOperator(String s) {
        return "+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s);
    }

    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }

        return true;
    }

    private static int doMath(int first, int second, String operator) throws InvalidInput {
        if ("+".equals(operator)) {
            return first + second;
        }

        if ("-".equals(operator)) {
            return first - second;
        }

        if ("*".equals(operator)) {
            return first * second;
        }

        if (second == 0) {
            throw new InvalidInput("divide by zero");
        }

        return first / second;
    }


    static class InvalidInput extends Exception {
        public InvalidInput(String errorMessage) {
            super(errorMessage);
        }
    }

    @Test
    public void t1() throws Exception {
        ReversePolishNotation sol = new ReversePolishNotation();
        String [] a = {"0", "3", "/"};
        System.out.println(sol.evalRPN(a));
    }

    @Test
    public void t2() throws Exception {
        ReversePolishNotation sol = new ReversePolishNotation();

        String [] a = { "3","0", "/"};
        System.out.println(sol.evalRPN(a));
    }

    @Test
    public void t3() throws Exception {
        ReversePolishNotation sol = new ReversePolishNotation();

        String [] a = { "2", "1", "+", "3", "*"};
        System.out.println(sol.evalRPN(a));
    }

    @Test
    public void t4() throws Exception {
        ReversePolishNotation sol = new ReversePolishNotation();

        String [] a = { "1", "1", "+", "3", "*", "3"};
        System.out.println(sol.evalRPN(a));
    }

    @Test
    public void t5() throws Exception {
        ReversePolishNotation sol = new ReversePolishNotation();

        String [] a = { "*"};
        System.out.println(sol.evalRPN(a));
    }


}




