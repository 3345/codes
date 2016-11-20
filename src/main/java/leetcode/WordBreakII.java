package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by yulai on 11/10/16.
 */
public class WordBreakII {

    public List<String> WordBreakII(String s, Set<String> wordDict) {
        int len = s.length();
        List<ArrayList<String>> dp = new ArrayList<ArrayList<String>>();
        //ab {a,b}
        for (int i = 0; i < len; i++) {
            dp.add(new ArrayList<String>());
            String subzero = s.substring(0, i + 1);
            if (wordDict.contains(subzero)) {
                dp.add(i, new ArrayList<String>(Arrays.asList(subzero)));
            }
            for (int j = 0; j < i; j++) {
                if (dp.get(j) != null) {

                    String sub = s.substring(j + 1, i + 1);
                    if (wordDict.contains(sub)) {
                        List<String> prelist = dp.get(j);
                        ArrayList<String> nlist = new ArrayList<String>();
                        for (String ps : prelist) {
                            nlist.add(ps + " " + sub);
                        }

                        dp.get(i).addAll(nlist);

                    }
                }
            }
        }

        return dp.get(len - 1);
    }
}
