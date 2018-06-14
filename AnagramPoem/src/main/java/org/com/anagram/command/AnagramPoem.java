package org.com.anagram.command;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import org.com.anagram.beans.Line;
import org.com.anagram.beans.Verse;
import org.com.anagram.manager.AnagramManager;

public class AnagramPoem {

    // Contain a list of all the verses of the poem
    private List<Verse> verses;
    
    // Contain a list of all the lines of the poem
    private List<Line> lines;

    
    public AnagramPoem(InputStream ist) {
        addVerse(ist);
    }
    
    /**
     * Read the input file and fill the variables verse and lines
     * 
     * @param inputFile contain the poem
     */
    private void addVerse(InputStream inputFile) {
        verses = new LinkedList<Verse>();
        lines = new LinkedList<Line>();
        try (Scanner s = new Scanner(inputFile).useDelimiter(
                        Pattern.compile("\\s*^\\s*$\\s*", Pattern.MULTILINE))) {
            while (s.hasNext()) {
                String line = s.next();
                AnagramManager.setLines(line, lines);
                verses.add(new Verse(line));
            }
        }
    }

    /**
     * Check if the poem is anagrammatic or not
     * 
     * @return true if the poem is anagrammatic, false if it isn't it 
     */
    public boolean isValid() {
        boolean isAValidAngramPoem = false;
        if (!verses.isEmpty() && !lines.isEmpty()) {
            // Check if it is an anagram poem by verse
            // If the poem only has one verse we have to check line by line
            if (verses.size() > 1) {
                isAValidAngramPoem = AnagramManager.isAnagramByVerse(verses);
            }
            // If the poem isn't anagram by verse 
            // we check if it is an anagram poem by line
            if (!isAValidAngramPoem) {
                isAValidAngramPoem = AnagramManager.isAnagramByLine(lines);
            }
        }
        return isAValidAngramPoem;        
    }

}
