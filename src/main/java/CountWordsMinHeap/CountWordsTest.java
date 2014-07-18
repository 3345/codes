package CountWordsMinHeap;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
        List<String> expected = new ArrayList<String>(Arrays.asList("bad", "good", "better", "worst"));
        assertEquals(expected, countWords.order(text, 10));
    }

    @Test
    public void leadingTrailingNonLetter() {
        String text = "#good bad better better worst good bad bad bad bad$";
        List<String> expected = new ArrayList<String>(Arrays.asList("bad", "good", "better", "worst"));
        assertEquals(expected, countWords.order(text, 10));
    }

    @Test
    public void nonCharactersInBetweenWords() {
        String text = "goo6d bad better ** be tter worst=-good bad bad bad bad";
        List<String> expected = new ArrayList<String>(Arrays.asList("bad", "good", "tter", "worst", "goo", "be", "d", "better"));
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
        int num = 3;
        String text = readFile();
        List<String> list = countWords.order(text, num);
        System.out.println(list.size());
        System.out.println(list);
    }

    private String readFile() throws Exception {
        // the file is about 12MB
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
