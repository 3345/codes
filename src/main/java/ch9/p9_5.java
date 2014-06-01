package ch9;

import org.junit.Test;

public class p9_5 {
    public static int search(String[] strArray, String target, int left, int right) {
        if (left > right)
            return -1;

        int mid = (left + right) >> 1;

        while (strArray[mid].equals("") && mid < right) {
            mid ++;
        }

        if (mid <= right && !strArray[mid].equals("")) {
            int result = strArray[mid].compareTo(target);
            if (result == 0)
                return mid;
            if (result < 0)
                return search(strArray, target, mid + 1, right);
            return search(strArray, target, left, mid -1);
        }

        mid = (left + right) >> 1;

        while (strArray[mid].equals("") && mid > left) {
            mid --;
        }

        if (mid >= left && !strArray[mid].equals("")) {
            int result = strArray[mid].compareTo(target);
            if (result == 0)
                return mid;
            if (result < 0)
                return -1;
            return search(strArray, target, left, mid -1);
        }

        return -1;
    }

    @Test
    public void t1() {
        String [] a = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        System.out.println(search(a, "ballcar", 0, a.length - 1));
     
    }
}
