package leetcode;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fyl on 12/4/16.
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        if (n == 0) {
            return Arrays.asList(0);
        }

        if (n == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(1);
            return list;
        }

        List<Integer> prev = grayCode(n - 1);
        List<Integer> list = new ArrayList<>();

        int pad = 1;

        for (int i = 0; i < n - 1; i++) {
            pad = pad << 1;
        }

        for (int i = 0; i < prev.size(); i++) {
            Integer in = prev.get(prev.size() - 1 - i);
            list.add(pad | in);
        }

        prev.addAll(list);

        return prev;

    }

    @Test
    public void t() {
        List<Integer> l = grayCode(2);
        System.out.println(new Gson().toJson(l));

    }

}
