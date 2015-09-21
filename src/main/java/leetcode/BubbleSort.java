package leetcode;


import org.junit.Test;

public class BubbleSort {
    public void bubbleSort(int[] a) {
        for (int i = 1; i < a.length; i ++) {
            boolean swapped = false;
            for (int j = 0; j < a.length - i; j ++ ) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

    @Test
    public void test() {
        int[] a = {1,3,5,1,3,2,4};
        int[] b = {1,2,3,1};
        int[] c = {5,3,4};
        bubbleSort(a);
        print(a);
        //print(b);
       // print(c);
    }

    private void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
