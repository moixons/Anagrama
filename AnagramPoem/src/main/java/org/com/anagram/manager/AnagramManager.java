package org.com.anagram.manager;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.com.anagram.beans.Line;
import org.com.anagram.beans.Verse;

public class AnagramManager {
 
    /**
     * Check if it is an anagram poem by verse
     * 
     * @param verses A list which contain all the verses of the poem
     * @return boolean, true if the poem is anagrammatic by verse or
     *                  false if the poem is not anagrammatic by verse
     */
    public static boolean isAnagramByVerse(List<Verse> verses) {
        boolean isAValidAngramPoem = true;
        Map<String, Long> ocurrencies = verses.get(0).getOcurrencies();
        for (Verse anagramVerse : verses) {
            Map<String, Long> actOcurrencies = anagramVerse.getOcurrencies();
            isAValidAngramPoem = isAValidAngramPoem && ocurrencies.equals(actOcurrencies);
            if (!isAValidAngramPoem) {
                return isAValidAngramPoem;
            }
        }
        return isAValidAngramPoem;
    }
    
    /**
     * Check if it is an anagram poem by line
     * 
     * @param lines A list which contain all the lines of the poem
     * @return boolean, true if the poem is anagrammatic by lines or
     *                  false if the poem is not anagrammatic by lines
     */
    public static boolean isAnagramByLine(List<Line> lines) {
        boolean isAValidAngramPoem = true;
        Map<String, Long> ocurrencies = lines.get(0).getOcurrencies();
        for (Line line : lines) {
            Map<String, Long> actOcurrencies = line.getOcurrencies();
            isAValidAngramPoem = isAValidAngramPoem && ocurrencies.equals(actOcurrencies);
            if (!isAValidAngramPoem) {
                return isAValidAngramPoem;
            }
        }
        return isAValidAngramPoem;
    }
    
    /**
     * Given a verse generates a list of the lines of this
     * 
     * @param verse
     * @param lines
     * @return 
     */
    public static List<Line> setLines(String verse, List<Line> lines) {        
        InputStream ist = new ByteArrayInputStream(verse.getBytes());
        try (Scanner s = new Scanner(ist).useDelimiter("\n")) {
            while (s.hasNext()) {
                String line = s.next();
                lines.add(new Line(line));
            }
        }
        return lines;
    }
    
}
