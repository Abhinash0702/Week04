package list_interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem04_RemoveDuplicates {
    public static void duplicateRemoval(List<Integer> list){
        ArrayList<Integer> list2 = new ArrayList<>();
        for(int a: list){
            if(!list2.contains(a)){
                list2.add(a);
            }
        }
        list=list2;

    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(4,3,6,4,8,6,9));
        System.out.println("Original List"+list);
        duplicateRemoval(list);
        System.out.println("After duplicate removal"+list);
    }
}
