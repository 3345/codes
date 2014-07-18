package CountWords;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CountWordsTest {
    CountWords countWords;

    @Before
    public void setUp() {
        countWords = new CountWords();
    }

    @Test
    public void returnEmptyList_whenInputIsEmptyString() {
        List<String> result = countWords.order("");
        assertTrue(result.isEmpty());
    }

    @Test
    public void returnEmptyList_whenInputIsNull() {
        List<String> result = countWords.order(null);
        assertTrue(result.isEmpty());
    }

    @Test
    public void simpleUseCase() {
        String text = "good bad better better worst good bad bad bad bad";
        List<String> expected = new ArrayList<String>(Arrays.asList("bad", "better", "good", "worst"));
        assertEquals(expected, countWords.order(text));
    }

    @Test
    public void leadingTrailingNonLetter() {
        String text = "#good bad better better worst good bad bad bad bad$";
        List<String> expected = new ArrayList<String>(Arrays.asList("bad", "better", "good", "worst"));
        assertEquals(expected, countWords.order(text));
    }

    @Test
    public void nonCharactersInBetweenWords() {
        String text = "goo6d better ** worst=-good bad bad bad bad";
        List<String> expected = new ArrayList<String>(Arrays.asList("bad", "better", "d", "goo", "worst", "good"));
        assertEquals(expected, countWords.order(text));
    }

    @Test
    public void ingoreCase() {
        String text = "Good, good, Hi, HI, hI";
        List<String> expected = new ArrayList<String>(Arrays.asList("hi", "good"));
        assertEquals(expected, countWords.order(text));
    }
}
