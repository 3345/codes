package ch1;

public class p1_1 {

    public static boolean isUniqueChars (String str) {
        boolean [] char_set= new boolean[256];
        for (int i = 0; i < str.length(); i ++) {
            int index = str.charAt(i);
            if (char_set[index] == true) {
                return false;
            }
            else {
                char_set[index] = true;
            }
        }
        return true;
    }

    public static boolean isUniqueChars2 (String str) {
        int bitSet = 0;
        for (int i = 0; i < str.length(); i ++) {
            int offset = str.charAt(i);
            int pos = 1 << offset;
            if ( ((bitSet | pos) == bitSet)) {
                return false;
            }
            else {
                bitSet = bitSet | pos;
            }
        }
        return true;
    }
}


