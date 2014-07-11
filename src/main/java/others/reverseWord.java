package others;

import org.junit.Assert;
import org.junit.Test;

public class reverseWord {
    public String reverseWords(String str) {
        char[] s = str.toCharArray();
        int start = 0;
        int end = s.length - 1;
        s = reverse(s, start, end);
        while (start < s.length - 1) {
            while (s[start] == ' ') {
                start++;
            }
            end = start + 1;

            while (end < s.length && s[end] != ' ') {
                end ++;
            }
            reverse(s, start, end - 1);
            start = end ++;
        }
        return new String(s);
    }

    private char[] reverse(char[] s, int start, int end) {
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start ++;
            end --;
        }
        return s;
    }

    @Test
    public void t1() {
        char[] a = {'a','b','c'};
        System.out.println(reverse(a, 0, a.length-1));
        String s = " the  blue  sky ";
        System.out.println(reverseWords(s));
    }
}
