package set_interface;

import java.util.*;

public class Problem04_ConvertSetToSortedList {
    public static List<Integer> convertSetToSortedList(Set<Integer> set) {
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Set.of(5, 3, 9, 1));

        System.out.println(convertSetToSortedList(set)); // Output: [1, 3, 5, 9]
    }
}

