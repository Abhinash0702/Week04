package set_interface;

import java.util.HashSet;
import java.util.Set;

public class Problem03_SymmetricDifference {
    public static Set<Integer> symmetricDifference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.addAll(set2);
        Set<Integer> common = new HashSet<>(set1);
        common.retainAll(set2);
        result.removeAll(common);
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Set.of(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Set.of(3, 4, 5));

        System.out.println(symmetricDifference(set1, set2)); // Output: {1, 2, 4, 5}
    }
}

