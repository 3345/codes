package leetcode;

import org.junit.Test;

public class ExpressiveWords {
    public int expressiveWords(String s, String[] words) {
        int count = 0;
        for (String p : words) {
            if (isValid(s, p)) count++;
        }
        return count;
    }

    private boolean isValid(String s, String p) {
        int ptrS = 0;
        int ptrP = 0;

        while (ptrS < s.length() && ptrP < p.length()) {
            int ctS = 0;
            int ctP = 0;
            char curS = s.charAt(ptrS);
            char curP = p.charAt(ptrP);
            if (curS != curP) return false;
            if (ptrS == s.length()-1 && ptrP == p.length()-1) return true;

            while (ptrS < s.length() - 1 && s.charAt(ptrS+1) == curS) {
                ptrS++;
                ctS++;
            }
            while (ptrP < p.length() - 1 && p.charAt(ptrP+1) == curP) {
                ptrP++;
                ctP++;
            }
            if (ctS < ctP) return false;
            if (ctS != ctP && ctS < 2) return false;
            ptrP++;ptrS++;
        }

        return ptrS == s.length() && ptrP == p.length();
    }

    @Test
    public void test() {
        String s = "heeellooo";
        String[] words = new String[]{"hello", "hi", "helo"};
        int ans = expressiveWords(s, words);
        System.out.println(ans);
    }
}
