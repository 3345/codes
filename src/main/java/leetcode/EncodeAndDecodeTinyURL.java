package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fyl on 10/23/17.
 */
public class EncodeAndDecodeTinyURL {
    private Map<Integer, String> store = new HashMap<>();
    private int count = 0;
    private String elements = "";

    public EncodeAndDecodeTinyURL() {
        for (char c = '0'; c <= '9'; c++) {
            this.elements += c;
        }

        for (char c = 'a'; c <= 'z'; c++) {
            this.elements += c;
        }

        for (char c = 'A'; c <= 'Z'; c++) {
            this.elements += c;
        }
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        store.put(count, longUrl);
        return this.base10to62(count++);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return store.get(base62to10(shortUrl));
    }

    private String base10to62(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(elements.charAt( n % 62));
            n /= 62;
        }

        int len = sb.length();

        for (int i = 0; i < 4 - len; i++) {
            sb.insert(0, '0');
        }

        return sb.toString();
    }

    private int base62to10(String s) {
        int r = 0;
        for (int i = 3; i > -1; i--) {
            char c = s.charAt(i);
            int n;
            if (c >= '0' && c <= '9') {
                n = c - '0';
            } else if (c >= 'a' && c <= 'z') {
                n = c - 'a' + 10;
            } else {
                n = c - 'A' + 36;
            }

            r += n * (Math.pow(62, 3 - i));
        }
        return r;
    }

    public static void main(String[] args) {
        EncodeAndDecodeTinyURL tinyURL = new EncodeAndDecodeTinyURL();

        System.out.println(tinyURL.decode(tinyURL.encode("http://animal.example.com/bee.php")));
    }
}
