package QueueInterface;

import java.util.Arrays;

public class Problem05_CircularBuffer {
    int[] buffer;
    int size, front, rear, count;

    public Problem05_CircularBuffer(int size) {
        this.size = size;
        buffer = new int[size];
        front = 0;
        rear = -1;
        count = 0;
    }

    public void insert(int x) {
        rear = (rear + 1) % size;
        buffer[rear] = x;
        if (count < size) count++;
        else front = (front + 1) % size; // Overwrite the oldest element
    }

    public void display() {
        for (int i = 0; i < count; i++) {
            System.out.print(buffer[(front + i) % size] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Problem05_CircularBuffer buffer = new Problem05_CircularBuffer(3);
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        buffer.display();
        buffer.insert(4);
        buffer.display();
    }
}

