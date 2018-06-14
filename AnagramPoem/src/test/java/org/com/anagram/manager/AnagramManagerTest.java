package org.com.anagram.manager;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import org.com.anagram.beans.Line;
import org.com.anagram.beans.Verse;
import org.junit.Test;
import static org.junit.Assert.*;

public class AnagramManagerTest {
    
    private static final String POEM1 = "abc\n"
                + "bca\n"
                + "cab\n"
                + "\n"
                + "abc\n"
                + "bca\n"
                + "cab\n"
                + "\n"
                + "abc\n"
                + "bca\n"
                + "cab\n";
   
    private static final String POEM2 = "abc\n"
                + "bca\n"
                + "cab\n"
                + "abc\n"
                + "bca\n"
                + "cab\n"
                + "abc\n"
                + "bca\n"
                + "cab\n";
    
    /**
     * Test of isAnagramByVerse method, of class AnagramManager.
     */
    @Test
    public void testIsAnagramByVerse() {
        List<Verse> verses = getVerse(POEM1);
        boolean result = AnagramManager.isAnagramByVerse(verses);
        assertTrue(result);
    }

    /**
     * Test of isAnagramByLine method, of class AnagramManager.
     */
    @Test
    public void testIsAnagramByLine() {
        List<Line> lines = new LinkedList<Line>();
        AnagramManager.setLines(POEM2, lines);
        boolean result = AnagramManager.isAnagramByLine(lines);
        assertTrue(result);
    }

    /**
     * Test of setLines method, of class AnagramManager.
     */
    @Test
    public void testSetLines() {
        List<Line> lines = new LinkedList<Line>();
        int expResult = 9;
        List<Line> result = AnagramManager.setLines(POEM2, lines);
        assertEquals(expResult, result.size());
    }
    
    
    private List<Verse> getVerse(String inputFile) {
        List<Verse> verses = new LinkedList<Verse>();
        try (Scanner s = new Scanner(inputFile).useDelimiter(
                        Pattern.compile("\\s*^\\s*$\\s*", Pattern.MULTILINE))) {
            while (s.hasNext()) {
                String line = s.next();
                verses.add(new Verse(line));
            }
        }
        return verses;
    }
}
