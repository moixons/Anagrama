package org.com.anagram;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.com.anagram.command.AnagramPoem;

public class Anagram {

    /**
     * The main class that receives the path's file and check if it is anagrammatic or not
     * 
     * @param args 
     */
    public static void main(String[] args) {
        InputStream input = null;
        // Check arguments
        if (args.length != 1) {
            System.out.println("The path of the file containing the poem to analyze is needed.");
            System.exit(0);
        }
        try {
            // Create a file from argument
            input = new FileInputStream(args[0]);
            AnagramPoem ap = new AnagramPoem(input);
            if (ap.isValid()) {
                System.out.println("TRUE - Poem is anagrammatic");
            } else {
                System.out.println("FALSE - Poem is not anagrammatic");
            }
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
    }

}
