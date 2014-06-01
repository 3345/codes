package ch8;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class p8_4 {
    private static Set<String> inserts(String c, String s) {
        Set set = new HashSet<String>();

        for (int i = 0; i < s.length() + 1; i ++){
            set.add(s.substring(0, i) + c + s.substring(i, s.length()));
        }

        return set;
    }

    public static Set<String> permutation(String s) {
        Set set = new HashSet<String>();

        if (s.length() == 0) {
            return set;
        }

        if (s.length() == 1) {
            set.add(s);
            return set;
        }

        String c = s.substring(0, 1);

        for (String s1 : permutation(s.substring(1))) {
            set.addAll(inserts(c, s1));
        }

        return set;
    }

    @Test
    public void t1() {
        Set<String> set = permutation("123");
        Gson gson = new Gson();
        System.out.println(gson.toJson(set));

    }
}
