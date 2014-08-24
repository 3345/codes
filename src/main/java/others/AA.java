package others;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AA {
    static List<Integer> mergeArrays(List<Integer> arr1, List<Integer> arr2) {
        if (arr2 == null || arr2.size() == 0 )
            return arr1;
        if (arr1 == null || arr1.size() == 0)
            return arr2;

        List<Integer> result = new ArrayList<Integer>();
        int c1 = 0, c2 = 0;

        while (c1 < arr1.size() && c2 < arr2.size()) {
            if (arr1.get(c1) < arr2.get(c2)) {
                result.add(arr1.get(c1));
                c1 ++;
            } else {
                result.add(arr2.get(c2));
                c2 ++;
            }
        }

        while (c1 < arr1.size()) {
            result.add(arr1.get(c1));
            c1++;
        }

        while (c2 < arr2.size()) {
            result.add(arr2.get(c2));
            c2 ++;
        }

        return result;

    }

    public static String json_encode(Object obj) {
  	/* Enter your code here.
     *
     * Helpful type checking functions:
     * (obj instanceof String)
     * (obj instanceof Number)
     * (obj instanceof List)
     * (obj instanceof Map)
     *
     * Note: Collection types do not use generics, they are just
     * standard java.util.List or java.util.Map.
     */
        if (obj instanceof Number) {
             return ((Number) obj).intValue() + "";
        }
        if (obj instanceof String) {
             return "\"" + (String)obj + "\"";
        }
        if (obj instanceof List) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            Boolean firstElement = true;
            for (Object o : (List)obj) {
                if (!firstElement)
                    sb.append(",");
                sb.append(json_encode(o));
                firstElement = false;
            }
            sb.append("]");
            return sb.toString();
        }
        if (obj instanceof Map) {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            boolean firstElement = true;
            for (Object key : ((Map) obj).keySet()) {
                if (!firstElement)
                    sb.append(",");
                sb.append(json_encode(key));
                sb.append(":");
                sb.append(json_encode(((Map) obj).get(key)));
                firstElement = false;
            }
            sb.append("}");
            return sb.toString();
        }
        return null;
    }

}
