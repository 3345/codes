package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fuyul on 12/31/2016.
 */
public class IntegerToEnglishWords {
    Map<Integer, String> numMap = new HashMap<>();
    Map<Integer, String> tenthMap = new HashMap<>();
    Map<Integer, String> tMap = new HashMap<>();


    public String numberToWords(int num) {
        Map<Integer, String> numMap = new HashMap<>();
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
        tMap.put(8, "Eight");
        tMap.put(9, "Ninety");

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
            sb.append(" ");
            convertThreeDigits(m, sb);
            sb.append(" Million");
            num -= m * 1000000;
        }

        int k = num / 1000;

        if (k != 0) {
            sb.append(" ");
            convertThreeDigits(k, sb);
            sb.append(" Thousand");
            num -= k *  1000;
        }

        if ( num != 0) {
            convertThreeDigits(num, sb);
        }

        return sb.toString();
    }

    public void convertThreeDigits(int num, StringBuilder sb) {
        int hundred = num / 100;
        boolean hasH = false;
        if (hundred != 0) {
            sb.append(numMap.get(hundred));
            num -= 100 * hundred;
            hasH = true;
        }

        int tenth = num / 10;

        if (tenth == 1) {
            sb.append(tenthMap.get(num));
        } else if (tenth == 0) {
            if (num > 0) {
                if (hasH) {
                    sb.append("And ");
                }
                sb.append(numMap.get(num));
            }
        } else {
            sb.append(tMap.get(tenth));
            sb.append(" ");
            sb.append(numMap.get(num - tenth * 10));
        }
    }
}
