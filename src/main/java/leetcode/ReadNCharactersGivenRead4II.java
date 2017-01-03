package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fyl on 1/2/17.
 */
public class ReadNCharactersGivenRead4II {
    int read4(char[] buf) {
        return 0;
    }

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */

    char[] leftOver;

    public int read(char[] buf, int n){
        if (n == 0) {
            return 0;
        }

        int count = 0;
        int remainLen = buf.length;

        if (leftOver != null) {
            int numLeftOverToRead = Math.min(buf.length, Math.min(leftOver.length, n));
            System.arraycopy(leftOver, 0, buf, 0, numLeftOverToRead);
            n -= numLeftOverToRead;
            count += numLeftOverToRead;
            remainLen -= numLeftOverToRead;

            if (numLeftOverToRead == leftOver.length) {
                leftOver = null;
            } else if (numLeftOverToRead < leftOver.length) {
                char[] tmp = new char[leftOver.length - numLeftOverToRead];
                System.arraycopy(leftOver, numLeftOverToRead, tmp, 0, leftOver.length - numLeftOverToRead);
                leftOver = tmp;
            }
        }

        while (n > 0 && remainLen > 0) {
            char[] tmp = new char[4];
            int numRead = read4(tmp);
            int num = Math.min(Math.min(numRead, remainLen), n);
            System.arraycopy(tmp, 0, buf, count, num);
            count += num;
            n -= num;
            remainLen -= num;

            if (numRead > num) {
                leftOver = new char[numRead - num];
                System.arraycopy(tmp, num, leftOver, 0, numRead - num);
            }

            if (numRead < 4) {
                break;
            }
        }

        return count;
    }
}
