package IXL;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class StateUtilsTest {
    @Test
    public void printCorrectStateList() {
        String expected = "<select name=\"state\">\n" +
                "<option value=\"Alabama\">Alabama</option>\n" +
                "<option value=\"Alaska\">Alaska</option>\n" +
                "<option value=\"Arizona\">Arizona</option>\n" +
                "<option value=\"Arkansas\">Arkansas</option>\n" +
                "<option value=\"California\">California</option>\n" +
                "</select>\n";

        assertEquals(expected, StateUtils.createStateSelectList());
    }

    @Test
         public void canGetFullName_whenAbbreviationExists() {
        assertEquals("California", StateUtils.displayStateFullName("CA"));
        assertEquals("Alaska", StateUtils.displayStateFullName("AK"));
    }

    @Test
    public void canAbbreviation_whenFullNameExists() {
        assertEquals("AR", StateUtils.parseSelectedState("Arkansas"));
        assertEquals("AL", StateUtils.parseSelectedState("Alabama"));
    }

    @Test
    public void returnNull_whenGetFullName_withNonExistedAbbr() {
        assertEquals(null, StateUtils.displayStateFullName("XX"));
    }

    @Test
    public void returnNull_whenGetAbbr_withNonExistedName() {
        assertEquals(null, StateUtils.parseSelectedState("XX"));
    }
}
