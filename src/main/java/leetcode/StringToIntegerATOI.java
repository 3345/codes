package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fyl on 12/5/16.
 */
public class StringToIntegerATOI {
    public int myAtoi(String str) {
        //2147483647
        //-2147483648

        if (str == null || str.length() == 0) {
            return 0;
        }

        str = str.trim();

        Map<Character, Integer> map = new HashMap<>();
        map.put('0',0);
        map.put('1',1);
        map.put('2',2);
        map.put('3',3);
        map.put('4',4);
        map.put('5',5);
        map.put('6',6);
        map.put('7',7);
        map.put('8',8);
        map.put('9',9);

        Map<Integer, Integer> posMaxMap = new HashMap<>();
        Map<Integer, Integer> negMaxMap = new HashMap<>();

        posMaxMap.put(0, 7);
        posMaxMap.put(1, 4);
        posMaxMap.put(2, 6);
        posMaxMap.put(3, 3);
        posMaxMap.put(4, 8);
        posMaxMap.put(5, 4);
        posMaxMap.put(6, 7);
        posMaxMap.put(7, 4);
        posMaxMap.put(8, 1);
        posMaxMap.put(9, 2);

        negMaxMap.put(0, 8);
        negMaxMap.put(1, 4);
        negMaxMap.put(2, 6);
        negMaxMap.put(3, 3);
        negMaxMap.put(4, 8);
        negMaxMap.put(5, 4);
        negMaxMap.put(6, 7);
        negMaxMap.put(7, 4);
        negMaxMap.put(8, 1);
        negMaxMap.put(9, 2);
        boolean negative = false;


        if (str.charAt(0) == '+') {
            str = str.substring(1);
        } else if (str.charAt(0) == '-') {
            str = str.substring(1);
            negative = true;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i))) {
                str = str.substring(0, i);
                break;
            }
        }


        char[] arr = str.toCharArray();

        if (arr.length == 0) {
            return 0;
        }

        if (arr.length > 10) {
            if (negative) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }

        if (arr.length > 10) {
            return 0;
        }

        int pos = arr.length - 1;
        int val = 0;
        boolean safe = false;

        for (int i = 0; i < arr.length; i ++) {
            if (map.containsKey(arr[i])) {
                if (arr.length == 10 && !safe) {
                    if (negative) {
                        if ( map.get(arr[i]) > negMaxMap.get(pos)) {
                            return Integer.MIN_VALUE;
                        } else if (map.get(arr[i]) < negMaxMap.get(pos)) {
                            safe = true;
                        }

                    }
                    if (!negative) {
                        if (map.get(arr[i]) > posMaxMap.get(pos)) {
                            return Integer.MAX_VALUE;
                        } else if (map.get(arr[i]) < posMaxMap.get(pos)){
                            safe =  true;
                        }
                    }
                }



                double offset = Math.pow(10, pos);
                if (negative) {
                    val -= offset * map.get(arr[i]);
                } else {
                    val += offset  *  map.get(arr[i]);
                }



                pos--;
            } else {
                return 0;
            }
        }


        return val;

    }

    @Test
    public void t() {
        System.out.println(myAtoi("-2147483648"));
    }
}
