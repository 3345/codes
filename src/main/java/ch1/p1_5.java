package ch1;

public class p1_5 {
    public static String replace (String s) {
        char [] str = new char[100];
        int numOfSpaces = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                numOfSpaces++;
            }
            str[i] = c;
        }
        str[s.length()-1+2*numOfSpaces] = '\0';
        for (int i = s.length() - 1; i > -1; i--) {
            if (str[i] != ' ') {
                str[i + 2*numOfSpaces] = s.charAt(i);
            }
            else {
                str[i + 2*numOfSpaces] = '%';
                str[i + 2*numOfSpaces - 1] = '0';
                str[i + 2*numOfSpaces - 2] = '2';
                numOfSpaces--;
            }
        }

        return new String(str);
    }
}
