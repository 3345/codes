package leetcode;

import org.junit.Test;

/**
 * Created by fyl on 11/22/17.
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int place = 0;
        int num = 0;

        for (int i = s.length() - 1; i > -1; i--) {
            int digit = s.charAt(i) - 'A' + 1;
            num += digit * (Math.pow(26, place));
            place++;
        }

        return num;
    }

    @Test
    public void test() {
        ExcelSheetColumnNumber sol = new ExcelSheetColumnNumber();
        System.out.println(sol.titleToNumber("AB"));
    }
}
