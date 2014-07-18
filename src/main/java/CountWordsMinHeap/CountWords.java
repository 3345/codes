package CountWordsMinHeap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountWords {
    /**
     * @param text input text
     * @param num number of most frequent words
     * @return list of most frequently occurred word in descending order.
     *
     * a word is a string contains only alphabet
     * i.e. "1st" is not a word, but "st" is
     */
    public List<String> order(String text, int num) {
        List<String> result = new ArrayList<String>();

        if (text == null)
            return result;

        HashMap<String, Integer> frequencyMap = new HashMap<String, Integer>();
        MinHeap minHeap = new MinHeap(num);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i ++) {
            char c = Character.toLowerCase(text.charAt(i));
            if (!Character.isLetter(c)) {
                if (sb.length() == 0)
                    continue;

                String s = new String(sb);
                sb = new StringBuilder();
                updateFrequency(frequencyMap, s);

            } else {
                sb.append(c);
            }
        }

        if (sb.length() != 0) {
            String s = new String(sb);
            updateFrequency(frequencyMap, s);
        }

        for (String word : frequencyMap.keySet()) {
            minHeap.add(word, frequencyMap.get(word));
        }

        return minHeap.dump();

    }

    private void updateFrequency(HashMap<String, Integer> map, String s) {
        Integer frequency = map.get(s);
        if (frequency == null) {
            map.put(s, 1);
        } else {
            map.put(s, frequency + 1);
        }
    }
}
