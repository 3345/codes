package ch1;

import org.junit.Test;

public class p1_8 {
    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        StringBuilder sb = new StringBuilder(s1);
        sb.append(s1);
        String s3 = new String(sb);
        return s3.contains(s2);
    }

    @Test
    public void run() {
        String s1 = "aabb";
        String s2 = "abba";
        System.out.println(isRotation(s1,s2));
    }
}
