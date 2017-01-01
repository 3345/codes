package leetcode;

/**
 * Created by fyl on 12/31/16.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            if (b == null) {
                return "";
            } else {
                return b;
            }
        }

        if (b == null || b.length() == 0) {
            if (a == null) {
                return "";
            } else {
                return a;
            }
        }

        char[] ar = a.toCharArray();
        char[] br = b.toCharArray();
        char carry = '0';

        int pa = ar.length - 1;
        int pb = br.length - 1;

        StringBuilder sb = new StringBuilder();

        while (pa > -1 && pb > -1) {
            char[] sum = sum(ar[pa], br[pb]);

            if (carry == '1') {
                if (sum[1] == '0') {
                    sum[1] = '1';
                } else {
                    sum[0] = '1';
                    sum[1] = '0';
                }
            }

            sb.insert(0, sum[1]);
            carry = sum[0];

            pa --;
            pb --;
        }

        while (pa > -1) {
            if (carry == '0') {
                sb.insert(0, ar[pa]);
            } else {
                char[] sum = sum('1', ar[pa]);
                sb.insert(0, sum[1]);
                carry = sum[0];
            }

            pa --;
        }

        while (pb > -1) {
            if (carry == '0') {
                sb.insert(0, br[pb]);
            } else {
                char[] sum = sum('1', br[pb]);
                sb.insert(0, sum[1]);
                carry = sum[0];
            }

            pb --;
        }

        if (carry == '1') {
            sb.insert(0, '1');
        }

        return sb.toString();
    }

    //carry, sum
    public char[] sum(char a, char b) {
        if (a == '0') {
            return new char[]{'0', b};
        }

        if (b == '0') {
            return new char[]{'0', a};
        }

        return new char[]{'1', '0'};
    }
}
