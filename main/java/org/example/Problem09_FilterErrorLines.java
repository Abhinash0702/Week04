package org.example;

import java.io.*;

public class Problem09_FilterErrorLines {
    public static void filterErrorLines(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) { // Case-insensitive search
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "index.txt";
        filterErrorLines(filePath);
    }
}
