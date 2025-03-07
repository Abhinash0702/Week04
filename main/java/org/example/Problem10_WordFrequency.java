package org.example;

import java.io.*;
import java.util.*;

public class Problem10_WordFrequency {
    public static void main(String[] args) {
        String fileName = "index.txt";
        countTopWords(fileName);
    }

    public static void countTopWords(String fileName) {
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
            return;
        } catch (IOException e) {
            System.out.println("Error while reading the file: " + e.getMessage());
            return;
        }

        // Sorting by frequency in descending order
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCount.entrySet());
        sortedWords.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Display total word count
        int totalWords = wordCount.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println("Total words: " + totalWords);

        // Display top 5 frequent words
        System.out.println("Top 5 most frequent words:");
        for (int i = 0; i < Math.min(5, sortedWords.size()); i++) {
            System.out.println(sortedWords.get(i).getKey() + " - " + sortedWords.get(i).getValue());
        }
    }
}
