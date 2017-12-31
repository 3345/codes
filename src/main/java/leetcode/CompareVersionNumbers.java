package leetcode;

import org.junit.Test;

/**
 * Created by fyl on 12/29/17.
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        int s1 = 0, s2 = 0;
        while (s1 < version1.length() && s2 < version2.length()) {
            int[] info1 = extract(version1, s1);
            int[] info2 = extract(version2, s2);

            if (info1[1] != info2[1]) {
                return info1[1] < info2[1] ? -1 : 1;
            }

            s1 = info1[0] + 1;
            s2 = info2[0] + 1;
        }

        if (s1 >= version1.length() && s2 >= version2.length()) {
            return 0;
        }

        if (s1 >= version1.length()) {
            while (s2 < version2.length()) {
                int[] info = extract(version2, s2);
                if (info[1] != 0) {
                    return -1;
                }
                s2 = info[0] + 1;
            }
            return 0;
        } else {
            while (s1 < version1.length()) {
                int[] info = extract(version1, s1);
                if (info[1] != 0) {
                    return 1;
                }
                s1 = info[0] + 1;
            }
            return 0;
        }

    }


    private int[] extract(String v, int start) {
        StringBuilder sb = new StringBuilder();
        int cur = start;
        while (cur < v.length() && v.charAt(cur) == '0') {
            cur++;
        }

        while(cur < v.length() && v.charAt(cur) != '.') {
            sb.append(v.charAt(cur));
            cur++;
        }

        int val = 0;
        if (sb.length() != 0) {
            val = Integer.parseInt(sb.toString());
        }

        return new int[]{cur, val};

    }

    @Test
    public void test() {
        String v1 = "1";
        String v2 = "0";

        compareVersion(v1, v2);

    }
}
