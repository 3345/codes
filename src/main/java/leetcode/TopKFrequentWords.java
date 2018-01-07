package leetcode;

import org.junit.Test;

import java.util.*;

/**
 * Created by fyl on 1/5/18.
 */
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> list = new ArrayList<>();
        if (words == null || words.length == 0) {
            return list;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<String>[] arr = new List[words.length];
        map.entrySet().forEach(entry -> {
            if (arr[entry.getValue() - 1] == null) {
                arr[entry.getValue() - 1] = new ArrayList<>(Arrays.asList(entry.getKey()));
            } else {
                arr[entry.getValue() - 1].add(entry.getKey());
            }
        });
        for (int i = arr.length - 1; i > - 1; i--) {
            if (arr[i] != null) {
                Collections.sort(arr[i]);
                list.addAll(arr[i]);
            }
            if (list.size() > k) {
                return list.subList(0, k);
            }
        }
        return list.subList(0, k);
    }

    @Test
    public void test() {
        String[] words = {"a", "aa", "aaa"};
        int k = 2;
        topKFrequent(words , k);
    }
}
