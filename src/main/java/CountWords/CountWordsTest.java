package CountWords;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by yfu on 7/17/14.
 */
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
        List<String> expected = new ArrayList<String>(Arrays.asList("bad", "good", "better", "worst"));
        assertEquals(expected, countWords.order(text));
    }

    @Test
    public void leadingTrailingNonLetter() {
        String text = "#good bad better better worst good bad bad bad bad$";
        List<String> expected = new ArrayList<String>(Arrays.asList("bad", "good", "better", "worst"));
        assertEquals(expected, countWords.order(text));
    }

    @Test
    public void nonCharactersInBetweenWords() {
        String text = "goo6d bad better ** be tter worst=-good bad bad bad bad";
        List<String> expected = new ArrayList<String>(Arrays.asList("bad", "good", "tter", "worst", "goo", "be", "d", "better"));
        assertEquals(expected, countWords.order(text));
    }

    @Test
    public void ingoreCase() {
        String text = "Good, good, Hi, HI, hI";
        List<String> expected = new ArrayList<String>(Arrays.asList("hi", "good"));
        assertEquals(expected, countWords.order(text));
    }
}
