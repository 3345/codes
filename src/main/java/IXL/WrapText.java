package IXL;

/**
 QUESTION #3:

 Write a Java method that takes a String of text and inserts newline characters
 ('\n') so that each line of text has at most maxCharsPerLine characters (not
 counting the newline). It may also be necessary to delete some spaces.

 The method should obey the following rules:

 1. Words should never be broken up, unless a word has more than maxCharsPerLine
 characters in it.
 2. A word is any sequence of characters that contains no spaces.
 3. Existing line breaks should be preserved.
 4. Lines should not be made shorter than necessary. In other words, if an
 additional word would fit on a line it should go on that line.
 5. Words should be separated by either a single space or by one or more newlines.
 6. Lines cannot start or end with spaces.

 Assume that the text does not contain any other whitespace characters besides
 spaces and newlines.
 */
public class WrapText {
    public static String wrapText(String text, int maxCharsPerLine) {
        if (text == null || maxCharsPerLine < 1)
            return "";

        int column = 0;
        StringBuilder textBuilder = new StringBuilder();
        StringBuilder word = new StringBuilder();
        int i = 0;

        while (i < text.length() || word.length() > 0) {
            char c = ' ';
            if (i < text.length()) {
                c = text.charAt(i);
                if (c != ' ' && c != '\n') {
                    word.append(c);
                    i++;
                    continue;
                }
            }

            if (column != 0 && word.length() > 0 && column + 1 <= maxCharsPerLine) {
                textBuilder.append(c);
                column++;
            }

            if (word.length() <= maxCharsPerLine) {
                if (column + word.length() <= maxCharsPerLine) {
                    textBuilder.append(word);
                    column += word.length();
                    if (c == '\n')
                        textBuilder.append(c);
                    word = new StringBuilder();
                    i++;
                } else {
                    textBuilder.setCharAt(textBuilder.length() - 1, '\n');
                }
            } else {
                textBuilder.append(word.substring(0, maxCharsPerLine - column));
                textBuilder.append('\n');
                String remain = word.substring(maxCharsPerLine - column);
                word = new StringBuilder();
                word.append(remain);
            }

            if (textBuilder.length() > 0 && textBuilder.charAt(textBuilder.length() - 1) == '\n')
                column = 0;
        }

        textBuilder.append(word);

        return textBuilder.toString();
    }
}
