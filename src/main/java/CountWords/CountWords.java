package CountWords;

import java.util.*;

public class CountWords {
    public List<String> order(String text) {
        List<String> result = new ArrayList<String>();

        if (text == null)
            return result;

        int textLen = text.length();

        HashMap<String, Integer> frequencyMap = new HashMap<String, Integer>();
        List[] orderedBucket = new List[textLen];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < textLen; i ++) {
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
            int frequency = frequencyMap.get(word).intValue();
            if (orderedBucket[frequency] == null) {
                ArrayList<String> list = new ArrayList<String>();
                list.add(word);
                orderedBucket[frequency] = list;
            } else {
                orderedBucket[frequency].add(word);
            }
        }

        for (int i = textLen - 1; i >=0; i --) {
            if (orderedBucket[i] != null)
                result.addAll(orderedBucket[i]);
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
