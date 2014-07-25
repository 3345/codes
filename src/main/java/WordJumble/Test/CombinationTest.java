package WordJumble.Test;

import WordJumble.WordJumble;
import org.junit.Before;
import org.junit.Test;


public class CombinationTest {
    WordJumble.Combination combination = new WordJumble.Combination();

    @Test
    public void combination_shouldReturnCombOfAllLength() {
        String word = "abc";
        System.out.println(combination.combination(word));
    }

    @Test
    public void combo_shouldReturnCombOfSpecifiedLength() {
        String word = "abcd";
        System.out.println(combination.combine(word, 1));
        System.out.println(combination.combine(word, 2));
        System.out.println(combination.combine(word, 3));
        System.out.println(combination.combine(word, 4));
    }

    @Test
    public void combo_shouldReturnEmptyList_whenSpecifiedLengthOutOfRange() {
        String word = "abcd";
        System.out.println(combination.combine(word, 0));
        System.out.println(combination.combine(word, 5));
    }

    @Test
    public void dedup_whenInputContainsDuplicatedChars() {
        String word = "aaa";
        System.out.println(combination.combine(word, 2));
        word = "ababbbba";
        System.out.println(combination.combine(word, 3));
    }

}
