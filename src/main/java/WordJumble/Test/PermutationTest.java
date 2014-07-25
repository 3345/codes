package WordJumble.Test;

import WordJumble.WordJumble;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationTest {
    WordJumble.Permutation permutation = new WordJumble.Permutation();

    @Test
    public void basic() {
        List<Character> chars = new ArrayList<Character>(Arrays.asList('a', 'b', 'c'));
        System.out.println(permutation.permute(chars));
    }

    @Test
    public void dedup_whenInputContainsDuplicatedChars() {
        List<Character> chars = new ArrayList<Character>(Arrays.asList('a', 'b', 'b'));
        System.out.println(permutation.permute(chars));
    }

    @Test
    public void returnOne_whenInputCharsAreAllTheSame() {
        List<Character> chars = new ArrayList<Character>(Arrays.asList('b', 'b', 'b'));
        System.out.println(permutation.permute(chars));
    }
}
