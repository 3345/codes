package IXL;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WrapTextTest {

    @Test
    public void shouldReturnEmptyString_whenInputIsEmptyString() {
        String input = "";
        assertEquals("", WrapText.wrapText(input, 3));
    }

    @Test
    public void shouldReturnEmptyString_whenInputIsNull() {
        String input = null;
        assertEquals("", WrapText.wrapText(input, 3));
    }

    @Test
    public void shouldReturnEmptyString_whenMaxCharLessThanOne() {
        String input = "aaa";
        assertEquals("", WrapText.wrapText(input, 0));
        assertEquals("", WrapText.wrapText(input, -1));
    }

    @Test
    public void shouldRemoveLeadingSpaces() {
        String input = "   abc";
        assertEquals("abc", WrapText.wrapText(input, 3));
    }

    @Test
    public void shouldRemoveTrailingSpaces() {
        String input = "a     ";
        assertEquals("a", WrapText.wrapText(input, 2));
    }

    @Test
    public void shouldRemoveDuplicatedSpacesBetweenWords() {
        String input = "    aaa   bbb  ";
        assertEquals("aaa bbb", WrapText.wrapText(input, 7));
    }

    @Test
    public void shouldStartNewLine_whenWordCannotFitIn() {
        String input = "ab abc";
        assertEquals("ab\nabc", WrapText.wrapText(input, 3));
    }

    @Test
    public void shouldNotBreakWord_whenWordCannotFitIn_AndWordLengthSmallerThenMaxColumn() {
        String input = "ab aaaa";
        assertEquals("ab\naaaa", WrapText.wrapText(input, 4));
    }

    @Test
    public void shouldBreakWord_whenWordLengthGreaterThenMaxColumn() {
        String input = "aaaaaaaaaa";
        assertEquals("aaa\naaa\naaa\na", WrapText.wrapText(input, 3));
    }

    @Test
    public void shouldFillTheRemainingSpacesThenBreakWord_whenWordCannotFitIn_AndWordLengthGreaterThenMax() {
        String input = "ab aaaaa";
        assertEquals("ab a\naaaa", WrapText.wrapText(input, 4));
    }

    @Test
    public void shouldChangeLine_whenMeetsNewLineChar() {
        String input = "aa\na";
        assertEquals("aa\na", WrapText.wrapText(input, 3));
    }

    @Test
    public void OK_whenNewLineCharMetAtEndOfLine() {
        String input = "abc\nc";
        assertEquals("abc\nc", WrapText.wrapText(input, 3));
    }

    @Test
    public void newLineCharAtTheEndOfText_shouldNotBeIgnored() {
        String input = "aaa\n";
        assertEquals("aaa\n", WrapText.wrapText(input, 3));
    }

    @Test
    public void shouldChangeLineOnEveryNewLineChar_whenThereAreMultipleNewLineChar() {
        String input = "a\n\n\na";
        assertEquals("a\n\n\na", WrapText.wrapText(input, 3));
    }

    @Test
    public void keepOneCharPerLine_whenMaxCharIsOne() {
        String input = "a\n aa \naa";
        assertEquals("a\na\na\na\na", WrapText.wrapText(input, 1));
    }

    @Test
    public void oneNewLine() {
        String input = "\n";
        assertEquals("\n", WrapText.wrapText(input, 1));
    }


    @Test
    public void multipleNewLine() {
        String input = "\n\n\n";
        assertEquals("\n\n\n", WrapText.wrapText(input, 1));
        assertEquals("\n\n\n", WrapText.wrapText(input, 10));
    }

    @Test
    public void mixedCondition() {
        String input = "  a  \n b   cdavvv \n ";
        assertEquals("a\nb c\ndav\nvv\n", WrapText.wrapText(input, 3));
    }
}
