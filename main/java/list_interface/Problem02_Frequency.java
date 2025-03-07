package list_interface;

import java.util.*;

public class Problem02_Frequency {

    public static HashMap<String, Integer> calculateFrequency(List<String> list) {
        HashMap<String,Integer> map =new HashMap<>();
        for(int i=0;i<list.size();i++){
            if(!map.containsKey(list.get(i))){
                map.put(list.get(i),1);
            }
            else{
                map.put(list.get(i),map.get(list.get(i))+1);
            }
        }


        return map;
    }

    public static void main(String[] args) {
        String words[]={"apple", "banana", "apple", "orange"};
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, words);

        System.out.println(calculateFrequency(list));
    }

}
