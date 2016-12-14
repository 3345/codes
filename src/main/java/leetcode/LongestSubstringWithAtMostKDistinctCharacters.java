//package leetcode;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
///**
// * Created by yulai on 12/9/16.
// */
//public class LongestSubstringWithAtMostKDistinctCharacters {
//
//
//    public int lengthOfLongestSubstringKDistinct(String s, int k) {
//        if (s == null || s.length() == 0 || k == 0) {
//            return 0;
//        }
//
//        char[] a = s.toCharArray();
//        Map<Integer, List<Character>> listMap = new HashMap<>();
//        Map<Integer, Set<Character>> setMap = new HashMap<>();
//        Map<Integer, Integer> lenMap = new HashMap<>();
//
//
//        List<Character> list = new ArrayList<>();
//
//
//
//        listMap.put(0, Arrays.asList(a[0]));
//        Set<Character> set = new HashSet<>();
//        set.add(a[0]);
//        setMap.put(0, set);
//        lenMap.put(0,1);
//
//        int max = 0;
//
//        for (int i = 1; i < a.length; i++) {
//            if (listMap.get(i - 1).size() < k) {
//                if (listMap.get(i - 1).contains(a[i])) {
//
//                } else {
//                    lenMap.put(i, lenMap.get(i - 1) + 1);
//                    listMap.put(i , listMap.get(i - 1));
//                    listMap.get(i).add(a[i]);
//                    setMap.put(i, setMapa[i]);
//                }
//            }
//        }
//     }
//}
