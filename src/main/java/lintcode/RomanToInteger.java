package lintcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fyl on 12/3/17.
 */
public class RomanToInteger {
    Map<Character, Integer> value = new HashMap<>();

    public RomanToInteger() {
        value.put('I', 1);
        value.put('V', 5);
        value.put('X', 10);
        value.put('L', 50);
        value.put('C', 100);
        value.put('D', 500);
        value.put('M', 1000);
    }

    public int romanToInt(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i != s.length() - 1) {
                if ((s.charAt(i) == 'I' && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X'))
                        || (s.charAt(i) == 'X' && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C'))
                        || (s.charAt(i) == 'C' && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M'))) {
                    ans -= value.get(s.charAt(i));
                    continue;
                }
            }

            ans += value.get(s.charAt(i));
        }

        return ans;
    }

    @Test
    public void test() {
        String s= "MCMXCVI";
        RomanToInteger romanToInteger = new RomanToInteger();
        romanToInteger.romanToInt(s);
    }
}
