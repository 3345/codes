package leetcode;

import java.util.ArrayList;
import java.util.List;

class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (s == null || s.length() < 1) {
            return "";
        }

        List<char[]> list = new ArrayList<char[]>();
        int t = numRows - 1;
        int i = 0;

        while (i < s.length()) {
            if (t == numRows - 1 || t == 0) {
                char[] arr = new char[numRows];
                for (int ii = 0; ii < numRows; ii++) {
                    if(i < s.length()) {
                        arr[ii] = s.charAt(i);
                        i++;
                    } else {
                        break;
                    }
                }
                list.add(arr);
                if (t != 0) {
                    t--;
                } else {
                    t = numRows-1;
                }
                continue;
            }

            char[] arr = new char[numRows];
            arr[t] = s.charAt(i);

            list.add(arr);
            t--;
            i++;
            if (t == 0) {
                t = numRows - 1;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int m = 0; m < numRows; m++) {
            for (int n = 0; n < list.size(); n++) {
                char c = list.get(n)[m];
                if (c != '\u0000') {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }
}
