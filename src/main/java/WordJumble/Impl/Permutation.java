package WordJumble.Impl;

import WordJumble.WordJumble;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yfu on 7/24/14.
 */
public class Permutation {
    /**
     *
     * @param chars
     * @return permutations without duplication even if input has duplicated characters
     * eg. [a,b,b]->[[a,b,b],[b,a,b],[b,b,a]]
     */
    public List<List<Character>> permute(List<Character> chars) {
        List<List<Character>> result = new ArrayList<List<Character>>();
        permute(chars, 0, result);
        return result;
    }

    public void permute(List<Character> chars, int start, List<List<Character>> result) {
        if (start >= chars.size()) {
            List<Character> newChars = new ArrayList<Character>(chars);
            result.add(newChars);
        }

        for (int j = start; j <= chars.size() - 1; j++) {
            if (!containsDuplicate(chars, start, j)) {
                swap(chars, start, j);
                permute(chars, start + 1, result);
                swap(chars, start, j);
            }
        }
    }

    public void swap(List<Character> list, int i, int j) {
        Character temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    private boolean containsDuplicate(List<Character> chars, int start, int end) {
        for (int i = start; i <= end-1; i++) {
            if (chars.get(i)== chars.get(end)) {
                return true;
            }
        }
        return false;
    }


}
