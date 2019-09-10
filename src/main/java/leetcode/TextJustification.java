package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fyl on 12/18/16.
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> output = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            int j = i + 1;
            int len = words[i].length();
            while (j < words.length && len + 1 + words[j].length() <= maxWidth) {
                len += 1 + words[j].length();
                j++;
            }

            StringBuilder row = new StringBuilder();
            if (j == words.length) {
                for (int k = i; k < j; k++) {
                    row.append(words[k]);
                    pad(row, k != j - 1 ? 1 : maxWidth - row.length());
                }
            } else {
                if (j - i - 1 == 0) {
                    row.append(words[i]);
                    pad(row, maxWidth - words[i].length());
                } else {
                    len -= j - i - 1;
                    int avg = (maxWidth - len) / (j - i - 1);
                    int extra = (maxWidth - len) % (j - i - 1);
                    for (int k = i; k < j; k++) {
                        row.append(words[k]);
                        if (k != j - 1) {
                            pad(row, extra > 0 ? avg + 1 : avg);
                            extra--;
                        }
                    }
                }
            }
            output.add(row.toString());
            i = j;
        }
        return output;
    }

    private void pad(StringBuilder sb, int n) {
        for (int i = 0; i < n; i++) {
            sb.append(" ");
        }
    }

    @Test
    public void t() {
        String[] words = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        fullJustify(words, 20);
    }
}
