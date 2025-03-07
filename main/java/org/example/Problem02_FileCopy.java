package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Problem02_FileCopy {
    private static final int BUFFER_SIZE = 4096; // 4 KB chunk size

    public static void main(String[] args) {
        String sourceFilePath = "largeFile.dat";
        String destBuffered = "copy_buffered.dat";
        String destUnbuffered = "copy_unbuffered.dat";

        // Create a sample large file for testing
        createLargeFile(sourceFilePath, 100 * 1024 * 1024); // 100MB file

        // Measure performance with Buffered Streams
        long bufferedTime = copyFileWithBufferedStream(sourceFilePath, destBuffered);
        System.out.println("Buffered Stream Copy Time: " + bufferedTime + " ns");

        // Measure performance with Unbuffered Streams
        long unbufferedTime = copyFileWithUnbufferedStream(sourceFilePath, destUnbuffered);
        System.out.println("Unbuffered Stream Copy Time: " + unbufferedTime + " ns");
    }

    // Copies a file using BufferedInputStream and BufferedOutputStream
    private static long copyFileWithBufferedStream(String source, String destination) {
        long startTime = System.nanoTime();

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return System.nanoTime() - startTime;
    }

    // Copies a file using FileInputStream and FileOutputStream (unbuffered)
    private static long copyFileWithUnbufferedStream(String source, String destination) {
        long startTime = System.nanoTime();

        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return System.nanoTime() - startTime;
    }

    // Creates a large test file of given size (in bytes)
    private static void createLargeFile(String filePath, long size) {
        Path path = Paths.get(filePath);
        if (Files.exists(path)) {
            System.out.println("Test file already exists: " + filePath);
            return;
        }

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            byte[] buffer = new byte[BUFFER_SIZE];
            long written = 0;
            while (written < size) {
                fos.write(buffer);
                written += BUFFER_SIZE;
            }
            System.out.println("Created test file: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
