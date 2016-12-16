package leetcode;

/**
 * Created by fyl on 12/15/16.
 */
public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        if (words == null || words.length < 2) {
            return 0;
        }

        if (words.length == 2) {
            return 1;
        }

        int i1 = -1;
        int i2 = -1;
        int dist = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                i1 = i;
                if (i2 != -1) {
                    dist = Math.min(dist, Math.abs(i1-i2));
                }

            } else if (words[i].equals(word2)) {
                i2 = i;
                if (i1 != -1) {
                    dist = Math.min(dist, Math.abs(i1-i2));
                }


            }
        }

        return dist;
    }
}
