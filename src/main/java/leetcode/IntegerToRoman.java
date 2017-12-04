package leetcode;

import org.junit.Test;

/**
 * Created by fyl on 12/3/17.
 */
public class IntegerToRoman {
    private static final String[] ONES= {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    private static final String[] TENS = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] HUNDREDS = {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static final String THOUSAND = "M";

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int thousands = num / 1000;
        for (int i = 0; i < thousands; i++) {
            sb.append(THOUSAND);
        }
        num = num % 1000;
        if (num / 100 > 0) sb.append(HUNDREDS[num / 100 - 1]);
        num = num % 100;
        if (num / 10 > 0) sb.append(TENS[num / 10 - 1]);
        num = num % 10;
        if (num > 0) sb.append(ONES[num - 1]);
        return sb.toString();
    }

    @Test
    public void test() {
        IntegerToRoman sol = new IntegerToRoman();
        System.out.print(sol.intToRoman(5));
    }


}
