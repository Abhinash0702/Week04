package org.example;

import java.io.*;

public class Problem06_CopyLowerCase {
    public static void copyWithLowercase(String path) throws FileNotFoundException {
        try (BufferedReader read = new BufferedReader(new FileReader(path));
             BufferedWriter write = new BufferedWriter(new FileWriter("newFile.txt"))) {

            String line;
            while ((line = read.readLine()) != null) {
                write.write(line.toLowerCase());
                write.newLine();
            }
            System.out.println("File copied with lowercase successfully.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String path = "index.txt";
        try {
            copyWithLowercase(path);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
