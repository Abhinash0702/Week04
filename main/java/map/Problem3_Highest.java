package map;

import java.util.*;

class Problem3_Highest {

    public static String findKeyWithHighestValue(Map<String, Integer> map) {
        return map.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null); // Return null if the map is empty
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);

        String keyWithMaxValue = findKeyWithHighestValue(map);

        System.out.println("Key with the highest value: " + keyWithMaxValue);
    }
}
