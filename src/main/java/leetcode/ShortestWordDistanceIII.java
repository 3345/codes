package leetcode;

/**
 * Created by fyl on 12/16/16.
 */
public class ShortestWordDistanceIII {
    public int shortestDistance(String[] words, String word1, String word2) {
        if (words == null || words.length < 2) {
            return 0;
        }

        if (words.length == 2) {
            return 1;
        }

        int i1 =  Integer.MAX_VALUE;
        int i2 =  Integer.MAX_VALUE;
        int dist = Integer.MAX_VALUE;
        boolean toggle = false;

        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals(word1) && !words[i].equals(word2)) {
                continue;
            }

            if (words[i].equals(word1) && words[i].equals(word2)) {
                if(!toggle) {
                    i1 = i;
                } else {
                    i2 = i;
                }

                toggle = !toggle;
            } else if (words[i].equals(word1)) {
                i1 = i;


            } else if (words[i].equals(word2)) {
                i2 = i;
            }

            dist = Math.min(dist, Math.abs(i1-i2));

        }

        return dist;
    }

}
