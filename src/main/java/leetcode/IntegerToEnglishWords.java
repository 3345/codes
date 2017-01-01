package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fuyul on 12/31/2016.
 */
public class IntegerToEnglishWords {
    Map

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

        Map<Integer, String> tenthMap = new HashMap<>();
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
    }

    public void convertThreeDigits(int num, StringBuilder sb, Map<Integer, String> numMap) {
        int hundred = num / 100;
        if (hundred != 0) {
            sb.append(numMap.get(hundred));
            num -= 100 * hundred;
        }

        int tenth = num / 10;

        if (tenth == 1) {

        }
    }
}
