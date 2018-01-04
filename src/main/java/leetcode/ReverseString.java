package leetcode;

/**
 * Created by yulai.fu on 10/22/17.
 */
public class ReverseString {
    public String reverseString(String s) {
        if (s.length() <= 1) {
            return s;
        }
        char[] a = s.toCharArray();
        int i = 0;
        int j = a.length - 1;
        while (i < j) {
            char temp = a[j];
            a[j] = a[i];
            a[i] = temp;
            i++;
            j--;
        }

        return new String(a);
    }
}
