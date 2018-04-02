package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fyl on 4/1/18.
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        char[] arr = s.toCharArray();
        List<List<String>> ret = new ArrayList<>();
        helper(arr, 0, s.length() - 1, new ArrayList<>(), ret);
        return ret;
    }

    public void helper(char[] arr, int start, int end, List<String> list, List<List<String>> ret) {
        for (int i = start; i < end + 1; i++) {
            if (isPalindrome(arr, start, i)) {
                list.add(this.buildString(arr, start, i));
                if (i + 1 <= end) {
                    helper(arr, i + 1, end, list, ret);
                } else {
                    List<String> l = new ArrayList<>(list);
                    ret.add(l);
                }

                list.remove(list.size() - 1);

            }
        }
    }

    public boolean isPalindrome(char[] arr, int start, int end) {
        if (start == end) {
            return true;
        }

        while (end > start) {
            if (arr[start] != arr[end]) {
                return false;
            }
            start++; end--;
        }

        return true;
    }

    private String buildString(char[] arr, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(arr[i]);
        }

        return sb.toString();
    }


    @Test
    public void test() {
        String s = "aab";
        this.partition(s);
    }
}
