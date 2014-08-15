package others;

/**
 Validate if a given string is numeric.

 Some examples:
 "0" => true
 " 0.1 " => true
 "abc" => false
 "1 a" => false
 "2e10" => true
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() < 1 || s.charAt(s.length()-1) == 'e') return false;
        String[] sp = s.split("e");
        if (sp.length > 2 || sp.length < 1) return false;
        if (!valid(sp[0], false)) return false;
        if (sp.length == 1 || (sp.length == 2 && valid(sp[1], true))) return true;
        return false;
    }

    public boolean valid(String s, boolean integer) {
        int i = 0, start = 0;
        if (s.length() < 1) return false;
        if (s.charAt(0) == '-' || s.charAt(0) == '+') i = start = 1;
        if (start == s.length()) return false;
        char c;
        boolean flag = false, hasnumber = false;
        for (; i < s.length(); ++i) {
            c = s.charAt(i);
            if (c == '.') {
                if (!flag && !integer) flag = true;
                else return false;
                continue;
            }
            if (c < '0' || c > '9') return false;
            hasnumber = true;
        }
        return hasnumber;
    }
}
