package ch1;

import java.util.HashMap;
import java.util.Map;

public class p1_4 {
    public static void printMap(Map map) {
        for (Object key : map.keySet()) {
            System.out.print(key + " ");
            System.out.println(map.get(key));
        }
    }
    public static boolean anagramTest (String s1, String s2) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {

            if (map.get(s1.charAt(i)) == null) {
                map.put(s1.charAt(i), 1);
            }
            else {
                int count = map.get(s1.charAt(i));
                map.put(s1.charAt(i), ++count);
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            if (map.get(s2.charAt(i)) == null) {
                return false;
            }
            else {
                int count = map.get(s2.charAt(i));
                if (count == 1) {
                    map.remove(s2.charAt(i));
                }
                else {
                map.put(s2.charAt(i), --count);
                }
            }
        }

        return (map.size() == 0);
    }



}
