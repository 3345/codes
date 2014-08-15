package IXL;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 QUESTION #1:

 Write a Java method that takes an array of "sets" of String objects,
 and determines whether _all_ sets in the array are equivalent.

 Each "set" in the input array is represented as an array of String objects, in
 no particular order, and possibly containing duplicates. Nevertheless, when
 determining whether two of these "sets" are equivalent, you should disregard
 order and duplicates. For example, the sets represented by these arrays are
 all equivalent:

 {"a", "b"}
 {"b", "a"}
 {"a", "b", "a"}

 The signature for your method should be:

 public static boolean allStringSetsIdentical(String[ ][ ] sets)

 Examples of the method in operation:

 allStringSetsIdentical(new String[][] {{"a","b"},{"b","b","a"},{"b","a"}})
 returns true

 allStringSetsIdentical(new String[][] {{"a","b"},{"a"},{"b"}}) returns false
 */
public class StringSets {
    public static boolean allStringSetsIdentical(String[][] sets) {
        if (sets == null || sets.length == 0)
            return false;
        if (sets.length == 1)
            return true;

        NullStringComparator nullStringComparator = new NullStringComparator();

        TreeSet<String> source = new TreeSet<String>(nullStringComparator);
        Collections.addAll(source, sets[0]);
        for (int i = 1; i < sets.length; i ++) {
            TreeSet<String> target = new TreeSet<String>(nullStringComparator);
            Collections.addAll(target, sets[i]);
            if (source.size() != target.size())
                return false;
            Iterator<String> iterator = source.iterator();
            while (iterator.hasNext()) {
                String sourceString = iterator.next();
                if (sourceString == null) {
                    if (target.pollFirst() != null)
                        return false;
                }
                else if (!sourceString.equals(target.pollFirst()))
                    return false;
            }
        }
        return true;
    }
}

/**
 * A comparator that can compare strings that can be null
 */
class NullStringComparator implements Comparator<String>{
    /**
     *
     * @param s1 first string to compare
     * @param s2 second string to compare
     * @return -1 if the first string is null but the second is not
     *          0 if both strings are null
     *          1 if the second string is null but the first is not
     *          use natural comparison if both string is not null
     */
    @Override
    public int compare(String s1, String s2) {
        if (s1 == null && s2 == null)
            return 0;
        if (s1 == null)
            return 1;
        if (s2 == null)
            return -1;
        return s1.compareTo(s2);
    }
}
