package set_interface;

import java.util.*;
public class Problem01_CheckSets {

    public static boolean areSetsEqual(Set<Integer> set1, Set<Integer> set2) {
        return set1.equals(set2);
    }
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));

        // Checking if two sets are equal
        System.out.println("Are Set1 and Set2 equal? " + areSetsEqual(set1, set2));

    }
}
