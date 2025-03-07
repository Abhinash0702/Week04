package org.example;

import java.io.*;

public class Problem07_StudentDataBinaryFile {
    private static final String FILE_NAME = "students.dat";

    // Method to write student details to a binary file
    public static void writeStudentData() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME))) {
            // Writing sample student data
            dos.writeInt(101); // Roll Number
            dos.writeUTF("Alice"); // Name
            dos.writeDouble(3.8); // GPA

            dos.writeInt(102);
            dos.writeUTF("Bob");
            dos.writeDouble(3.5);

            dos.writeInt(103);
            dos.writeUTF("Charlie");
            dos.writeDouble(3.9);

            System.out.println("Student data written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Method to read student details from a binary file
    public static void readStudentData() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            System.out.println("\nReading student data from file:");
            while (dis.available() > 0) { // Read until end of file
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();

                System.out.println("Roll No: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        writeStudentData(); // Writing data
        readStudentData(); // Reading data back
    }
}
