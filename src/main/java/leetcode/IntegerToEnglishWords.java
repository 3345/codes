package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fuyul on 12/31/2016.
 */
public class IntegerToEnglishWords {
    static Map<Integer, String> numMap = new HashMap<>();
    static Map<Integer, String> tenthMap = new HashMap<>();
    static Map<Integer, String> tMap = new HashMap<>();

    static {
        numMap.put(1, "One");
        numMap.put(2, "Two");
        numMap.put(3, "Three");
        numMap.put(4, "Four");
        numMap.put(5, "Five");
        numMap.put(6, "Six");
        numMap.put(7, "Seven");
        numMap.put(8, "Eight");
        numMap.put(9, "Nine");

        tenthMap.put(10, "Ten");
        tenthMap.put(11, "Eleven");
        tenthMap.put(12, "Twelve");
        tenthMap.put(13, "Thirteen");
        tenthMap.put(14, "Fourteen");
        tenthMap.put(15, "Fifteen");
        tenthMap.put(16, "Sixteen");
        tenthMap.put(17, "Seventeen");
        tenthMap.put(18, "Eighteen");
        tenthMap.put(19, "Nineteen");

        tMap.put(2, "Twenty");
        tMap.put(3, "Thirty");
        tMap.put(4, "Forty");
        tMap.put(5, "Fifty");
        tMap.put(6, "Sixty");
        tMap.put(7, "Seventy");
        tMap.put(8, "Eighty");
        tMap.put(9, "Ninety");
    }


    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }


        //2,147,483,647
        int g = num / 1000000000;
        StringBuilder sb = new StringBuilder();

        if (g == 1) {
            sb.append("One Billion");
            num -= 1000000000;
        }

        if (g==2) {
            sb.append("Two Billion");
            num -= 2000000000;
        }

        int m = num / 1000000;

        if (m != 0) {
            convertThreeDigits(m, sb);
            sb.append(" Million");
            num -= m * 1000000;
        }

        int k = num / 1000;

        if (k != 0) {
            convertThreeDigits(k, sb);
            sb.append(" Thousand");
            num -= k *  1000;
        }

        if ( num != 0) {
            convertThreeDigits(num, sb);
        }

        return sb.toString().trim();
    }

    public void convertThreeDigits(int num, StringBuilder sb) {
        int hundred = num / 100;
        if (hundred != 0) {
            sb.append(" ");
            sb.append(numMap.get(hundred));
            sb.append(" Hundred");
            num -= 100 * hundred;
        }

        int tenth = num / 10;

        if (tenth == 1) {
            sb.append(" ");
            sb.append(tenthMap.get(num));
        } else if (tenth == 0) {
            if (num > 0) {
                sb.append(" ");
                sb.append(numMap.get(num));
            }
        } else {
            sb.append(" ");
            sb.append(tMap.get(tenth));
            num -= 10* tenth;
            if (num > 0) {
                sb.append(" ");
                sb.append(numMap.get(num));
            }
        }
    }

    @Test
    public void t() {
        System.out.println(numberToWords(1001));
    }

}
