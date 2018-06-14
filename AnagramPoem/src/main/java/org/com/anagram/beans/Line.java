package org.com.anagram.beans;

import java.util.Map;
import java.util.function.Function;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Class that represents a line of the poem
 * 
 */
public class Line {

    private String line;
    private Map<String, Long> ocurrencies;

    public Line(String line) {
        this.line = line;
        this.ocurrencies = getLetterOcurrencies(this.line);
    }

    /**
     * Create a Map which contains the occurrences of each letter of one line
     * 
     * @param line, line of the poem
     * @return a Map which contains the occurrences of each letter of one line
     */
    private Map<String, Long> getLetterOcurrencies(String line) {
        Map<String, Long> collect = line.chars().mapToObj(c -> String.valueOf((char) c).toLowerCase())
                .filter(s -> s.matches("\\w+"))
                .collect(groupingBy(Function.identity(), counting()));
        return collect;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public Map<String, Long> getOcurrencies() {
        return ocurrencies;
    }

    public void setOcurrencies(Map<String, Long> ocurrencies) {
        this.ocurrencies = ocurrencies;
    }

}
