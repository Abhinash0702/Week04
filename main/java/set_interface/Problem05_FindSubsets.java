package set_interface;

import java.util.HashSet;
import java.util.Set;

public class Problem05_FindSubsets {
    public static boolean isSubset(Set<Integer> subset, Set<Integer> mainSet) {
        return mainSet.containsAll(subset);
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Set.of(2, 3));
        Set<Integer> set2 = new HashSet<>(Set.of(1, 2, 3, 4));

        System.out.println(isSubset(set1, set2)); // Output: true
    }
}
