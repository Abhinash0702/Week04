package org.example;
import java.io.*;

public class Problem01_CopyTextFile {
    public static void copyTextFile(String sourcePath, String destinationPath) {
        File sourceFile = new File(sourcePath);

        // Check if source file exists
        if (!sourceFile.exists()) {
            System.out.println("Error: Source file does not exist.");
            return;
        }

        try (FileInputStream fileInput = new FileInputStream(sourceFile);
             FileOutputStream fileOutput = new FileOutputStream(destinationPath)) {

            byte[] buffer = new byte[4096]; // 4KB buffer for efficient reading
            int bytesRead;

            while ((bytesRead = fileInput.read(buffer)) != -1) {
                fileOutput.write(buffer, 0, bytesRead);
            }

            System.out.println("File copied successfully!");

        } catch (IOException e) {
            System.out.println("File operation error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String sourceFile = "index.txt";
        String destinationFile = "destination.txt";
        copyTextFile(sourceFile, destinationFile);
    }
}

