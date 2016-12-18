package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fyl on 12/18/16.
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();

        if (words == null || words.length == 0) {
            return ans;
        }

        int[] arr = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            arr[i] = words[i].length();
        }


        int i = 0;
        int curLen = 0;
        int curLenNoSpace = 0;
        int wordCount = 0;
        boolean start = true;

        while (i < arr.length) {
            if (!start) {
                curLen ++; //add a space
            } else {
                start = false;
            }

            curLen += arr[i];

            if (curLen <= maxWidth) {
                curLenNoSpace += arr[i];
                wordCount++;
            }

            if (curLen >= maxWidth) {
                if (curLen > maxWidth) {
                    i--;
                }
                addLine(maxWidth, ans, i, curLenNoSpace, wordCount, words);

                curLen = 0;
                curLenNoSpace = 0;
                wordCount = 0;
                start = true;
            }

            i++;
        }

        if (wordCount > 0) {
            i--;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < wordCount; j++) {
                sb.append(words[i - wordCount + 1 + j]);
                if (j < wordCount - 1) {
                    sb.append(" ");
                }
            }

            int len = maxWidth - sb.length();

            for (int j = 0; j < len; j++) {
                sb.append(" ");
            }

            ans.add(sb.toString());
        }

        return ans;
    }

    private void addLine(int maxWidth, List<String> ans, int i, int curLenNoSpace, int wordCount, String[] words) {
        StringBuilder padding = new StringBuilder();
        StringBuilder sb = new StringBuilder();


        if (wordCount > 1) {
            int baseSpace = (maxWidth - curLenNoSpace) / (wordCount - 1);
            int extraSpace = (maxWidth - curLenNoSpace) % (wordCount - 1);
            for (int j = 0; j < baseSpace; j++) {
                padding.append(" ");
            }

            for (int j = 0; j < wordCount; j++) {
                sb.append( words[i - wordCount + 1 + j]);
                if (j < wordCount - 1) {
                    sb.append(padding);
                    if (extraSpace > 0) {
                        sb.append(" ");
                        extraSpace --;
                    }
                }
            }

        } else {//word count == 1
            sb.append(words[i]);
            for (int j = 0; j < maxWidth - words[i].length(); j++) {
                sb.append(" ");
            }
        }

        ans.add(sb.toString());
    }

    @Test
    public void t() {
        String[] words = {"What","must","be","shall","be."};
        fullJustify(words, 12);
    }
}
