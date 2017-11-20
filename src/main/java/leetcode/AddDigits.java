package leetcode;

/**
 * Created by fyl on 11/19/17.
 */
public class AddDigits {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }

        return addDigits(addDigits(num / 10) + addDigits(num % 10));
    }
}
