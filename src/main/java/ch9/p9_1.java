package ch9;

import com.google.gson.Gson;
import org.junit.Test;

public class p9_1 {
    public static void merge(Object[] big, Object[] small) {
        int eos = 0, eob = 0;
        while (eos < small.length && small[eos] != null) eos++;
        while (eob < big.length && big[eob] != null) eob++;
        eos--; eob--;
        int end = big.length - 1;

        while (eob > -1 && eos > -1) {
            Integer s = (Integer) small[eos];
            Integer b = (Integer) big[eob];
            if (s > b) {
                big[end] = s;
                eos--;
            } else {
                big[end] = b;
                eob --;
            }

            end--;
        }

        while (eob > -1) {
            big[end] = big[eob];
            eob --; end --;
        }

        while (eos > -1) {
            big[end] = big[eos];
            eos --; end --;
        }

    }

    @Test
    public void t1() {
        Object[] big = {1, 5, 10, 15, 20, null, null, null};
        Object[] small = {5, 6, 30};
        merge(big, small);
        Gson gson = new Gson();
        System.out.println(gson.toJson(big));
    }
}
