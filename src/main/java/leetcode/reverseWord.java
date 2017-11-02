package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class reverseWord {
    public String reverseWords(String str) {
        char[] arr = new char[str.length()];

        int arrIndex = 0;
        boolean firstSpace = false;

        int s = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                s = i;
                break;
            }
        }

        for (int i = str.length() - 1; i >= s; i--) {
            char c = str.charAt(i);
            if (c != ' ') {
                firstSpace = true;
                arr[arrIndex] = c;
                arrIndex++;
            } else {
                if (firstSpace) {
                    arr[arrIndex] = ' ';
                    arrIndex++;
                    firstSpace = false;
                }
            }
        }



        int start = 0;
        int end = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                if (start != i) {
                    end = i - 1;
                    this.reverse(arr, start, end);
                }
                break;

            }
            if (arr[i] == ' ') {
                end = i - 1;
                this.reverse(arr, start, end);
                start = i + 1;
            }
        }

        if (start == 0) {
            this.reverse(arr, start, end);
        } else if (start > end) {
            this.reverse(arr, start, arr.length - 1);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                sb.append(arr[i]);
            } else {
                break;
            }
        }



        return sb.toString();
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
        String s = "hello hi";
        System.out.println(reverseWords(s));
    }
}
