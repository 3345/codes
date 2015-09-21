package leetcode;

import java.util.Stack;

/**
 Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (isOpen(c))
                stack.push(c);
            else if (stack.isEmpty())
                return false;
            else if (!match(stack.pop(), c))
                return false;
        }
        return stack.isEmpty();
    }

    private boolean isOpen(char c) {
        return (c == '(' || c == '{' || c == '[');
    }

    private boolean match(char c1, char c2) {
        if (c1 == '(')
            return c2 == ')';
        if (c1 == '[')
            return c2 == ']';
        if (c1 == '{')
            return c2 == '}';
        return false;
    }
}
