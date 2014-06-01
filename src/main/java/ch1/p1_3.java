package ch1;

import java.util.ArrayList;
import java.util.List;

public class p1_3 {
    public static void removeDuplicates (String s) {
        int len = s.length();
        if (len < 2)
            System.out.println(s);

        else {
            for (int i = 0; i < s.length() - 1; i ++) {
                String sub = s.substring(i+1).replaceAll(String.valueOf(s.charAt(i)), "");
                s = s.substring(0, i+1) + sub;
            }
            System.out.println(s);
        }
    }

    public static void removeDuplicates2 (String s) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++) {
            list.add(String.valueOf(s.charAt(i)));
        }
        if (list.size() < 2) {
            System.out.println(s);
        }
        else {
            for (int i = 0; i < list.size() - 1; i++) {
                String target = list.get(i);
                for (int j = i + 1; j < list.size() ; j++) {
                    if (list.get(j).equals(target)) {
                        list.remove(j);
                        j--;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (String s1 : list) {
                sb.append(s1);
            }
            String result = new String(sb);
            System.out.println(result);
        }
    }

}
