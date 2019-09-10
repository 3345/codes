package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaystoAddParentheses {
    List<Integer> nums = new ArrayList<>();
    List<Character> ops = new ArrayList<>();

    public List<Integer> diffWaysToCompute(String input) {
        String curNum = "";
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                nums.add(Integer.parseInt(curNum));
                ops.add(c);
                curNum = "";
            } else {
                curNum += c;
            }
        }
        nums.add(Integer.parseInt(curNum));


        return dfs(0, nums.size()-1);
    }

    public List<Integer> dfs(int start, int end) {
        List<Integer> ret = new ArrayList<>();
        if (start == end) {
            ret.add(nums.get(start));
            return ret;
        }
        for (int i = start; i < end; i++) {
            char op = ops.get(i);
            List<Integer> left = dfs(start, i);
            List<Integer> right = dfs(i+1, end);
            for (Integer l : left) {
                for (Integer r : right) {
                    int res = 0;
                    switch (op) {
                        case '+':
                            res = l + r;
                            break;
                        case '-':
                            res = l - r;
                            break;
                        case '*':
                            res = l * r;
                            break;
                    }

                    ret.add(res);
                }
            }
        }
        return ret;
    }

    @Test
    public void test() {
        String input = "2-1-1";
        List<Integer> ans = diffWaysToCompute(input);
        ans.forEach(System.out::println);
    }
}
