package CountWords;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
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
        List<String> result = countWords.order("", 10);
        assertTrue(result.isEmpty());
    }

    @Test
    public void returnEmptyList_whenInputIsNull() {
        List<String> result = countWords.order(null, 10);
        assertTrue(result.isEmpty());
    }

    @Test
    public void simpleUseCase() {
        String text = "good bad better better worst good bad bad bad bad";
        List<String> expected = new ArrayList<String>(Arrays.asList("bad", "better", "good", "worst"));
        assertEquals(expected, countWords.order(text, 10));
    }

    @Test
    public void leadingTrailingNonLetter() {
        String text = "#good bad better better worst good bad bad bad bad$";
        List<String> expected = new ArrayList<String>(Arrays.asList("bad", "better", "good", "worst"));
        assertEquals(expected, countWords.order(text, 10));
    }

    @Test
    public void nonCharactersInBetweenWords() {
        String text = "goo6d better ** worst=-good bad bad bad bad";
        List<String> expected = new ArrayList<String>(Arrays.asList("bad", "better", "d", "goo", "worst", "good"));
        assertEquals(expected, countWords.order(text, 10));
    }

    @Test
    public void ingoreCase() {
        String text = "Good, good, Hi, HI, hI";
        List<String> expected = new ArrayList<String>(Arrays.asList("hi", "good"));
        assertEquals(expected, countWords.order(text, 10));
    }

    @Test
    public void bigFile() throws Exception {
        String text = readFile();
        List<String> list = countWords.order(text, 3);
        System.out.println(list.size());
        System.out.println(list);
    }

    private String readFile() throws Exception {
        File file = new File("/Users/yfu/Downloads/codes/src/main/java/CountWords/big.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");

        while((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }

        return stringBuilder.toString();
    }
}
