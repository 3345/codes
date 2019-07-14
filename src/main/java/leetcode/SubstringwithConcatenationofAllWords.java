//package leetcode;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * Created by fyl on 5/29/19.
// */
//public class SubstringwithConcatenationofAllWords {
//    public List<Integer> findSubstring(String s, String[] words) {
//        int wordCount = words.length;
//        int wordLen = words[0].length();
//        int sLen = s.length();
//        int l = 0, r = 0;
//        Map<String, Integer> map = new HashMap<>();
//
//        for (String w : words) {
//            map.put(w, map.getOrDefault(w, 1));
//        }
//
//        List<Integer> ans = new ArrayList<>();
//
//        while (l <  sLen - wordCount *  wordLen && r < sLen) {
//              String nextWord = s.substring(r, r+wordLen);
//
//
//        }
//    }
//
//}
