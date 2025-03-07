package list_interface;

import java.util.LinkedList;

public class Problem05_FindNthElement {

        public static String findNthFromEnd(LinkedList<String> list, int N) {
            if (list == null || N <= 0) {
                return "Invalid Input"; // Handle edge cases gracefully
            }

            int fastIndex = 0;
            int slowIndex = 0;

            // Move fast pointer N steps ahead
            while (fastIndex < N) {
                if (fastIndex >= list.size()) {
                    return "Invalid Input"; // N is larger than list size
                }
                fastIndex++;
            }

            // Move both pointers one step at a time
            while (fastIndex < list.size()) {
                fastIndex++;
                slowIndex++;
            }

            // Now, slowIndex points to the Nth element from the end
            return list.get(slowIndex);
        }

        public static void main(String[] args) {
            LinkedList<String> list = new LinkedList<>();
            list.add("A");
            list.add("B");
            list.add("C");
            list.add("D");
            list.add("E");

            int N = 2; // Find the 2nd element from the end
            System.out.println("Nth element from the end: " + findNthFromEnd(list, N));


    }

}
