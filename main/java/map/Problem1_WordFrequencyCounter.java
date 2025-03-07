package map;

import java.io.*;
import java.util.*;
import java.util.regex.*;

class Problem1_WordFrequencyCounter {

    public static Map<String, Integer> countWordFrequency(String filePath) {
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\W+");  // Split by non-word characters (punctuation, spaces)
                for (String word : words) {
                    if (!word.isEmpty()) {
                        word = word.toLowerCase();  // Convert word to lowercase
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return wordCount;
    }

    public static void main(String[] args) {
        String filePath = "sample.txt";  // Replace with your file path
        Map<String, Integer> result = countWordFrequency(filePath);

        System.out.println("Word Frequency: " + result);
    }
}
