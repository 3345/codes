package ch1;

public class p1_2 {
    public static String reverseCStyleString(String inputString) {
        char [] chars = inputString.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        if (end == 0)
            return "";

        while (start <  end) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start ++;
            end --;
        }
        return new String(chars);
    }
}
