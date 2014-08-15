package IXL;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 QUESTION #2:

 Reason why this is better:
 1. code is shorter more maintainable, if one wants to modify the states info, she/he can
    simply modify the static block. The original version will require modifying every method.
 2. The getters are faster thanks to the using of linked hash map, while keeping the alphabetical order.
    But the performance enhancement should be indiscernible because there are only 50 states.
*/

public class StateUtils {
    private static LinkedHashMap<String, String> nameMap = new LinkedHashMap<String, String>();
    private static LinkedHashMap<String, String> abbrMap = new LinkedHashMap<String, String>();

    static {
        addState("Alabama", "AL");
        addState("Alaska", "AK");
        addState("Arizona", "AZ");
        addState("Arkansas", "AR");
        addState("California", "CA");
    }
    //
    // Generates an HTML select list that can be used to select a specific
    // U.S. state.
    //
    public static String createStateSelectList()
    {
        StringBuilder sb = new StringBuilder("<select name=\"state\">\n");
        for (String name : nameMap.keySet()) {
            sb.append(String.format("<option value=\"%1$s\">%1$s</option>\n", name));
        }
        sb.append("</select>\n");
        return sb.toString();
    }

    //
    // Parses the state from an HTML form submission, converting it to
    // the two-letter abbreviation. We need to store the two-letter abbreviation
    // in our database.
    //
    public static String parseSelectedState(String name) {
        return nameMap.get(name);
    }

    //
    // Displays the full name of the state specified by the two-letter code.
    //
    public static String displayStateFullName(String abbr) {
        return abbrMap.get(abbr);
    }

    private static void addState(String name, String abbr) {
        nameMap.put(name, abbr);
        abbrMap.put(abbr, name);
    }
}
