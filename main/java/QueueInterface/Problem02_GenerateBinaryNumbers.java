package QueueInterface;

import java.util.LinkedList;
import java.util.Queue;

public class Problem02_GenerateBinaryNumbers {
    public static void generateBinaryNumbers(int N) {
        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        for (int i = 0; i < N; i++) {
            String current = queue.remove();
            System.out.print(current + " ");
            queue.add(current + "0");
            queue.add(current + "1");
        }
    }

    public static void main(String[] args) {
        int N = 5;
        generateBinaryNumbers(N); // Output: 1 10 11 100 101
    }
}

