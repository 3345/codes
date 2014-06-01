package ch8;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.*;

public class p8_3 {

    public static void subSets (List<Integer> list, Set<Set<Integer>> sets) {
        if (list.size() == 0)
            return;

        Integer head = list.remove(0);
        Set<Set<Integer>> newSets = new HashSet<Set<Integer>>();

        for (Set set : sets) {
            Set newSet = new HashSet(set);
            newSet.add(head);
            newSets.add(newSet);
        }

        sets.addAll(newSets);
        Set set = new HashSet();
        set.add(head);
        sets.add(set);

        subSets(list, sets);

    }

    @Test
    public void t1() {
        List list = new ArrayList(Arrays.asList(1,2,3));
        Set<Set<Integer>> results = new HashSet<Set<Integer>>();
        subSets(list, results);
        Gson gson = new Gson();
        System.out.println(gson.toJson(results));

    }

    @Test
    public void ha() {
        String s = "abc";
        System.out.println(s.substring(0,0));
        System.out.println(s.substring(0,s.length()-1));

    }

}
