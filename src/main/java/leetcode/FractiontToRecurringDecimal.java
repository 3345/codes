package leetcode;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * Created by yulai on 12/13/16.
 */
public class FractiontToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        if (denominator == 0) {
            return "";
        }

        int sign = 1;

        if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
            sign = -1;
        }

        Long nu = Math.abs(new Long(numerator));
        Long de = Math.abs(new Long(denominator));

        long whole = nu / de;
        StringBuilder sb = new StringBuilder();
        sb.append(whole);

        Map<Long, Integer> set = new HashMap<>();

        long n = nu % de;
        if (n == 0) {
            if (sign == - 1) {
                return "-" + sb.toString();
            }
            return sb.toString();
        }

        sb.append('.');
        StringBuilder sb2 = new StringBuilder();
        int index = 0;

        while(n != 0) {
            if (set.containsKey(n)) {
                index = set.get(n);
                break;
            }
            set.put(n, index);
            whole = n * 10 / de;
            n = n * 10 % de;
            sb2.append(whole);
            index ++;
        }

        if (n != 0) {
            sb2.insert(index, "(");
            sb.append(sb2);
            sb.append(")");
        } else {
            sb.append(sb2);
        }

        if (sign == -1) {
            return "-" + sb.toString();
        }

        return sb.toString();
    }

    @Test
    public void t() {
        System.out.println(fractionToDecimal(-2147483648,1));
    }
}
