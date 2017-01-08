package leetcode;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by fuyul on 1/7/2017.
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        boolean neg1 = num1.charAt(0) == '-';
        boolean neg2 = num2.charAt(0) == '-';
        String sign = neg1 == neg2 ? "" : "-";

        if (neg1) {
            num1 = num1.substring(1);
        }

        if (neg2) {
            num2 = num2.substring(1);
        }

        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        if ("1".equals(num1)) return sign + num2;
        if ("1".equals(num2)) return sign + num1;

        String s = num1;
        String l = num2;

        if (num2.length() == Math.min(num1.length(), num2.length())) {
            s = num2;
            l = num1;
        }

        LinkedList<Integer> ln = new LinkedList<>();
        for (int i = 0; i < l.length(); i++) {
            ln.add(Integer.parseInt(l.charAt(i) + ""));
        }

        LinkedList<Integer> prev = null;

        for (int i = s.length() - 1; i > -1; i--) {
            LinkedList<Integer> cur = mult(ln, Integer.parseInt(s.charAt(i) + ""));
            for (int j = 0; j < i; j++) {
                cur.add(0);
            }
            if (prev == null) {
                prev = cur;
            } else {
                prev = sum(cur, prev);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < prev.size(); i++) {
            sb.append(prev.get(i));
        }

        return sb.toString();
    }


    //second number must be single digits
    public LinkedList<Integer> mult(LinkedList<Integer> n, int single) {
        LinkedList<Integer> ret = new LinkedList<>();
        if (single == 0) {
            ret.add(0);
            return ret;
        }

        if (single == 1) {
            return (LinkedList<Integer>) n.clone();
        }

        int carry = 0;
        for (int i = n.size() - 1; i > -1; i--) {
            int product = single * n.get(i) + carry;
            ret.addFirst( product % 10);
            carry = product / 10;
        }

        if (carry != 0) {
            ret.addFirst(carry);
        }

        return ret;
    }

    public LinkedList<Integer> sum(LinkedList<Integer> n1, LinkedList<Integer> n2) {
        LinkedList<Integer> ret = new LinkedList<>();
        int p1 = n1.size() - 1;
        int p2 = n2.size() - 1;
        int carry = 0;

        while (p1 > -1 && p2 > -1) {
            int sum = n1.get(p1) + n2.get(p2) + carry;
            ret.addFirst(sum % 10);
            carry = sum / 10;
            p1 --;
            p2 --;
        }

        while (p1 > -1) {
            int sum = n1.get(p1) + carry;
            ret.addFirst(sum % 10);
            carry = sum / 10;
        }

        while (p2 > -1) {
            int sum = n2.get(p2) + carry;
            ret.addFirst(sum % 10);
            carry = sum / 10;
        }

        if (carry > 0) {
            ret.addFirst(carry);
        }

        return ret;
    }

    @Test
    public void testSum() {
        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();

        l1.add(1);
        l1.add(2);
        l1.add(3);

        l2.add(9);
        l2.add(8);
        l2.add(7);

        LinkedList<Integer> l = sum(l1, l2);
        System.out.println(new Gson().toJson(l));
    }

    @Test
    public void testMult() {
        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();

        l1.add(4);
        l1.add(5);
        l1.add(6);

        l2.add(9);
        l2.add(8);
        l2.add(7);

        LinkedList<Integer> l = mult(l1, 3);
        System.out.println(new Gson().toJson(l));
    }

    @Test
    public void test() {
        System.out.println(multiply("123","456"));
    }
}
