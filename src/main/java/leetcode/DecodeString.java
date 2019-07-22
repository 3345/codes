package leetcode;

import java.util.Stack;

/**
 * Created by fyl on 7/17/19.
 */
public class DecodeString {
    public String decodeString(String s) {
        String sb = "";
        String cursb = "";
        String digit = "";
        Stack<Integer> numStack = new Stack();
        Stack<String> stack = new Stack<>(); // string stack

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (this.isDigit(c)) {
                digit += c;
                continue;
            }
            if (c == '[') {
                stack.push(cursb);
                cursb = "";
                int num = Integer.parseInt(digit);
                digit = "";
                numStack.push(num);
                continue;
            }
            if (c == ']') {

                int num = numStack.pop();
                StringBuilder sbflush = new StringBuilder();
                for (int j = 0; j < num; j++) {
                    sbflush.append(cursb);
                }
                cursb = stack.pop() + sbflush;
                continue;
            }
            if (stack.isEmpty()) {
                sb += cursb;
                cursb = "";
                sb += c;
            } else {
                cursb += c;
            }

        }
        sb += cursb;
        return sb;
    }

    private boolean isDigit(Character c) {
        return c >= '0' && c <= '9';
    }

}
