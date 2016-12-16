package leetcode;

import org.junit.Test;

/**
 * Created by fyl on 12/15/16.
 */
public class AddictiveNumber {
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) {
            return false;
        }

        int len = num.length();
        int maxi = Math.min(len / 2, 11);

        for (int i = 0; i < maxi; i++) {
            if (num.charAt(0) == '0' && i != 0) {
                return false;
            }

            int maxj = len - i - 1;
            //j inclusive
            for (int j = i + 1; j < maxj; j ++) {

                if (num.charAt(i + 1) == '0' && j != i + 1) {
                    break;
                }

                int qs = i + 1;
                int qe = j;

                long n = Long.parseLong(num.substring(0, i + 1));
                long m = Long.parseLong(num.substring(qs, qe + 1));
                long sum = n + m;
                String sumString = "" + sum;

                int rs = qe + 1;
                int re = rs + sumString.length() - 1;

                while (re < len) {
                    if (num.charAt(rs) == '0' && (re != rs)) {
                        break;
                    }

                    if (num.substring(rs, re + 1).equals(sumString)) {
                        if (re == len - 1) {
                            return true;
                        }

                        qs = rs;
                        qe = re;

                        n = m;
                        m = Long.parseLong(num.substring(qs, qe + 1));
                        sum = n + m;
                        sumString = "" + sum;

                        rs = qe + 1;
                        re = rs + sumString.length() - 1;

                    } else {
                        break;
                    }
                }


            }
        }

        return false;
    }

    @Test
    public void t() {
        System.out.println(isAdditiveNumber("111122335588143"));
    }
}
