package leetcode;

/**
 * Created by fyl on 12/4/16.
 */
public class ReverseWordsInAStringII {
    public void reverseWords(char[] s) {
        reverse(0, s.length - 1, s);

        int start = 0;
        int end = 0;

        while(end < s.length) {
            if (end == s.length - 1 || s[end + 1] == ' ') {
                reverse(start, end, s);
                start = end + 2;
                end = end + 2;
            } else {
                end ++;
            }

        }
    }

    public void reverse(int start, int end, char[] s) {
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start ++;
            end --;
        }
    }
}
