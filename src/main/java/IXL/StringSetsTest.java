package IXL;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringSetsTest {
    @Test
    public void returnTrue_whenAreTheSame_basic() {
        String[][] sets = {{"a","b"},{"a","b"},{"a","b"}};
        assertTrue(StringSets.allStringSetsIdentical(sets));
    }

    @Test
    public void returnFalse_whenNotTheSame_basic() {
        String[][] sets = {{"a","b"},{"a","cb"},{"a","b"}};
        assertFalse(StringSets.allStringSetsIdentical(sets));
    }

    @Test
    public void returnFalse_whenNotTheSame_StringsContainsSameChars() {
        String[][] sets = {{"ab"},{"ba"}};
        assertFalse(StringSets.allStringSetsIdentical(sets));
    }

    @Test
    public void returnTrue_whenAreTheSame_OutOfOrder() {
        String[][] sets = {{"aaa","bbb", "ccc"},{"bbb","aaa", "ccc"},{"ccc", "aaa","bbb"}};
        assertTrue(StringSets.allStringSetsIdentical(sets));
    }

    @Test
    public void returnTrue_whenAreTheSame_ContainDuplicates() {
        String[][] sets = {{"ab","ab","bc"},{"ab","bc", "bc"},{"ab", "bc"}};
        assertTrue(StringSets.allStringSetsIdentical(sets));
    }

    @Test
    public void returnTrue_whenAreTheSame_ContainNulls() {
        String[][] sets = {{"ab",null},{"ab",null, null},{null, "ab", "ab"}};
        assertTrue(StringSets.allStringSetsIdentical(sets));
    }

    @Test
    public void returnFalse_whenNotTheSame_ContainNulls() {
        String[][] sets = {{"ab",null},{"ab"},{null, "ab", "ab"}};
        assertFalse(StringSets.allStringSetsIdentical(sets));
    }

    @Test
    public void gg() {
        System.out.println(String.format("xxx %1$s xxx %1$s", "what"));
    }
}
