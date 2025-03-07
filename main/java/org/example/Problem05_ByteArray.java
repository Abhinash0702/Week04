package org.example;


import java.io.*;
        import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Problem05_ByteArray {
    public static void main(String[] args) {
        String sourceImagePath = "input.jpg";
        String destinationImagePath = "output.jpg";

        try {
            // Convert image to byte array
            byte[] imageData = convertImageToByteArray(sourceImagePath);

            // Write byte array back to an image file
            writeByteArrayToImage(imageData, destinationImagePath);

            // Verify if both files are identical
            boolean isIdentical = verifyImages(sourceImagePath, destinationImagePath);
            System.out.println("Are the original and copied images identical? " + isIdentical);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Reads an image file and converts it to a byte array
    private static byte[] convertImageToByteArray(String imagePath) throws IOException {
        Path path = Paths.get(imagePath);
        return Files.readAllBytes(path);
    }

    // Writes a byte array back to an image file
    private static void writeByteArrayToImage(byte[] imageData, String outputPath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
             FileOutputStream fos = new FileOutputStream(outputPath)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
        System.out.println("Image successfully written to " + outputPath);
    }

    // Compares two image files to check if they are identical
    private static boolean verifyImages(String file1, String file2) throws IOException {
        byte[] file1Bytes = Files.readAllBytes(Paths.get(file1));
        byte[] file2Bytes = Files.readAllBytes(Paths.get(file2));
        return Arrays.equals(file1Bytes, file2Bytes);
    }
}
