package map;

import java.util.*;

class Problem4_Merging {

    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> mergedMap = new HashMap<>(map1);

        map2.forEach((key, value) ->
                mergedMap.merge(key, value, Integer::sum)
        );

        return mergedMap;
    }

    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        Map<String, Integer> result = mergeMaps(map1, map2);

        System.out.println("Merged Map: " + result);
    }
}
