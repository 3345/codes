package WordJumble.Impl;


import java.io.*;

public class Dictionary {
    public String dict;
    public String path;
    public Trie trie;

    public Dictionary (String path) {
        trie = new Trie();
        File file = new File(path);
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;

            while((line = reader.readLine()) != null) {
                String word = decode(line);
                trie.add(word);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The dictionary file used in this program contains words in the format of <word>/<annotation>
     * e.g. hello/MS
     * This method strip the annotation from it.
     */
    private String decode(String word) {
        return word.split("//", 1)[0];
    }
}
