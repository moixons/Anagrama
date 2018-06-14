package org.com.anagram.beans;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.com.anagram.manager.AnagramManager;

/**
 * Class that represents a verse of the poem
 */
public class Verse {

    private String verse;
    private List<Line> lines;

    public Verse(String verse) {
        this.verse = verse;
        this.lines = new LinkedList<>();
        AnagramManager.setLines(verse, lines);
    }
    
    public String getVerse() {
        return verse;
    }

    public void setVerse(String verse) {
        this.verse = verse;
    }

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    /**
     * Create a Map which contains the occurrences of each letter of one verse
     * 
     * @return a Map which contains the occurrences of each letter of one verse
     */
    public Map<String, Long> getOcurrencies() {
        Map<String, Long> collect = new HashMap<>();
        lines.stream().forEach(l -> {
                l.getOcurrencies().forEach((k, c) -> {
                collect.put(k, collect.getOrDefault(k, 0l) + c);
            });
        });
        return collect;
    }
    
}
