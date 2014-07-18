package CountWords;

import java.util.*;

/**
 * Created by yfu on 7/17/14.
 */
public class CountWords {
    public List<String> order(String text) {
        List<String> result = new ArrayList<String>();

        if (text == null)
            return result;

        HashMap<String, Integer> frequencyMap = new HashMap<String, Integer>();
        MaxHeap maxHeap = new MaxHeap();

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
            maxHeap.add(word, frequencyMap.get(word));
        }

        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.remove());
        }

        return result;

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
