package leetcode;

import org.junit.Test;

import java.util.Stack;

public class BasicCalculatorIII {
    public int calculate(String s) {
        int l1 = 0; int o1 = 1;
        int l2 = 1; int o2 = 1;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;

            if (c >= '0' && c <= '9') {
                int num = c - '0';

                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(++i) - '0');
                }

                l2 = (o2 == 1 ? l2 * num : l2 / num);
            }


            if (c == '*' || c == '/') {
                o2 = c == '*' ? 1 : -1;
            }

            if (c == '+' || c == '-') {
                if (c == '-' && (i == 0 || s.charAt(i - 1) == '(')) {
                    o1 = -1;
                    continue;
                }
                l1 += l2*o1;
                l2 = 1; o2 = 1;
                o1 = c == '+' ? 1 : -1;
            }

            if (c == '(') {
                stack.push(l1);stack.push(o1);stack.push(l2);stack.push(o2);
                l1 = 0; o1 = 1; l2 = 1; o2 = 1;
            }

            if (c == ')') {
                int num = l1 + l2*o1;
                o2 = stack.pop();
                l2 = stack.pop();
                l2 = o2 == 1 ? l2*num : l2/num;
                o1 = stack.pop();
                l1 = stack.pop();
            }
        }

        return l1 + l2*o1;
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    @Test
    public void test() {
        String s = "-1+4*3/3/3";
        calculate(s);
    }
}
