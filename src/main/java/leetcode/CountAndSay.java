package leetcode;

/**
 * Created by fuyul on 1/5/2017.
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 0) {
            return "0";
        }

        if (n == 1) {
            return "1";
        }

        String prev = "1";
        for (int i = 1; i < n; i++) {
            prev = solve(prev);
        }

        return prev;
    }

    public String solve(String s) {
        StringBuilder sb = new StringBuilder();
        char cur = s.charAt(0);
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == cur) {
                count ++;
            } else {
                sb.append(count);
                sb.append(cur);
                cur = s.charAt(i);
                count = 1;
            }
        }

        sb.append(count);
        sb.append(cur);

        return sb.toString();
    }
}
