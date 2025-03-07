package org.example;



import java.io.*;

class WriterThread extends Thread {
    private PipedOutputStream outputStream;

    public WriterThread(PipedOutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        try {
            String message = "Hello from Writer Thread!";
            outputStream.write(message.getBytes()); // Writing data as bytes
            outputStream.flush();
            outputStream.close();
            System.out.println("Writer: Data written successfully.");
        } catch (IOException e) {
            System.out.println("Writer error: " + e.getMessage());
        }
    }
}

class ReaderThread extends Thread {
    private PipedInputStream inputStream;

    public ReaderThread(PipedInputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        try {
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            String receivedMessage = new String(buffer, 0, bytesRead);
            System.out.println("Reader: Received -> " + receivedMessage);
            inputStream.close();
        } catch (IOException e) {
            System.out.println("Reader error: " + e.getMessage());
        }
    }
}

public class Problem08_PipedStream {
    public static void main(String[] args) {
        try {
            // Creating piped streams
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos); // Connecting the streams

            // Creating and starting threads
            WriterThread writer = new WriterThread(pos);
            ReaderThread reader = new ReaderThread(pis);

            writer.start();
            reader.start();

        } catch (IOException e) {
            System.out.println("Pipe connection error: " + e.getMessage());
        }
    }
}
