package leetcode;

/**
 * Created by fuyul on 1/2/2017.
 */
public class ReadNCharactersGivenRead4 {

      int read4(char[] buf) {
          return 0;
      }

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n){
        if (n == 0) {
            return 0;
        }

        int count = 0;
        int remainLen = buf.length;

        while (n > 0 && remainLen > 0) {
            char[] tmp = new char[4];
            int numRead = read4(tmp);
            int num = Math.min(Math.min(numRead, remainLen), n);
            System.arraycopy(tmp, 0, buf, count, num);
            count += num;
            n -= num;
            remainLen -= num;

            if (numRead < 4) {
                break;
            }
        }

        return count;
    }
}
