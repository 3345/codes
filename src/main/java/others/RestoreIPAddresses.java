package others;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 Given a string containing only digits, restore it by returning all possible valid IP address combinations.

 For example:
 Given "25525511135",

 return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if (s.length() <= 12 && s.length() >= 4)
            ip(s, "", 3, 0, result);
        return result;
    }

    public void ip(String s, String partial, int level, int start, List<String> result) {
        if (level < 0)
            return;

        if (level == 0) {
            if (start >= s.length() - 3 && start < s.length()) {
                String label = s.substring(start, s.length());
                if (Integer.parseInt(label) < 256 && !(label.length() > 1 && label.charAt(0) == '0'))
                    result.add(partial + label);
            }
            return;
        }

        for (int i = start; i < start + 3; i++) {
            if (i >= s.length())
                break;
            String label = s.substring(start, i + 1);
            if (Integer.parseInt(label) <= 255 && !(label.length() > 1 && label.charAt(0) == '0'))
                ip(s, partial + label + ".", level - 1, i + 1, result);
        }
    }

    @Test
    public void test() {
        String s = "010010";
        System.out.println(restoreIpAddresses(s));
    }
}
