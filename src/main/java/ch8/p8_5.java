package ch8;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class p8_5 {
    public static Set<String> parenthese(int n) {
        Set<String> set = new HashSet();
        if (n == 1) {
            set.add("()");
            return set;
        }

        for (String s : parenthese(n-1)) {
            set.add("()" + s);
            set.add(s + "()");
            set.add("(" + s + ")");
        }

        return set;
    }

    @Test
    public void t1() {
        Set<String> set = parenthese(3);
        Gson gson = new Gson();
        System.out.println(gson.toJson(set));
    }

}
