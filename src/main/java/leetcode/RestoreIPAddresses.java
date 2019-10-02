package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 Given a string containing only digits, restore it by returning all possible valid IP address combinations.

 For example:
 Given "25525511135",

 return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class RestoreIPAddresses {
    List<String> output = new ArrayList<>();
    String s;
    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        recur(0, 4, "");
        return output;
    }

    public void recur(int start, int remain, String cur) {
        if (remain == 0) {
            if (start == s.length()) {
                output.add(cur);
            }
        }

        int len = s.length() - start;
        if (len > 3*remain) {
            return;
        }

        for (int i = 1; i < 4; i++) {
            if (start+i > s.length()) {
                break;
            }
            String digits = s.substring(start,start+i);
            if (digits.length() > 0 && digits.charAt(0) == '0') {
                break;
            }
            int num = Integer.parseInt(digits);
            if (num < 256) {
                if (!cur.isEmpty()) {
                    digits = cur+"."+digits;
                }
                recur(start+i, remain-1, digits);
            }
        }
    }
    @Test
    public void test() {
        String s = "0000";
        System.out.println(restoreIpAddresses(s));
    }
}
