package org.com.anagram.command;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

public class AnagramPoemTest {

    private static final String POEM1 = "src/test/resources/anagram_poem.txt";
    private static final String POEM2 = "src/test/resources/anagram_poem2.txt";
    private static final String POEM3 = "src/test/resources/empty_poem.txt";
    private static final String POEM4= "src/test/resources/no_anagram_poeme.txt";
    
    @Test
    public void simpleAnagramPoem() {
        String apStr = "abc\n"
                + "bca\n"
                + "cab?\n"
                + "\n"
                + "abc\n"
                + "bca\n"
                + "cab?\n"
                + "\n"
                + "abc\n"
                + "bca\n"
                + "cab?\n";

        AnagramPoem ap = new AnagramPoem(new ByteArrayInputStream(apStr.getBytes()));
        assertTrue(ap.isValid());
    }

    @Test
    public void simpleIncorretAnagramPoem() {
        String apStr = "abc\n"
                + "bca\n"
                + "cab?\n"
                + "\n"
                + "abc\n"
                + "bcx\n"
                + "cab?\n"
                + "\n"
                + "abc\n"
                + "bca\n"
                + "cab?\n";

        AnagramPoem ap = new AnagramPoem(new ByteArrayInputStream(apStr.getBytes()));
        assertFalse(ap.isValid());
    }
    
    @Test
    public void correctPoemFromFile() {
        assertTrue(genericTest(POEM1));
    }
    
    @Test
    public void largePoemFromFile() {
        assertTrue(genericTest(POEM2));
    }
    
    @Test
    public void noAnagramPoemFromFile() {
        assertFalse(genericTest(POEM4));
    }
    
    @Test
    public void poemFromEmptyFile() {
        assertFalse(genericTest(POEM3));
    }
    
    private boolean genericTest(String pathFile) {
        FileInputStream input = null;
        try {
            input = new FileInputStream(pathFile);
            AnagramPoem ap = new AnagramPoem(input);
            return ap.isValid();
        } catch (FileNotFoundException ex) {
            System.out.println("Error reading input File" + ex);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    System.out.println("Error closing FileInputStream" + e);
                }
            }
        }
        return false;
    }

}
