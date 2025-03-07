package list_interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Problem01_ReverseList {

    public static void ReverseUsingArrayList(ArrayList<Integer> list) {
        int start = 0;
        int end = list.size() - 1;
        while (start <= end) {
            int temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;
            end--;
        }
    }

    public static void ReverseUsingLinkedList(LinkedList<Integer> list){
        int start = 0;
        int end = list.size() - 1;
        while (start <= end) {
            int temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Original List : "+list);
        ReverseUsingArrayList(list);
        System.out.println("After reverse: "+list);

        //using linkedlist
        LinkedList<Integer> ls=new LinkedList<>(Arrays.asList(11,12,13,14,15));
        System.out.println("Original Linked List : "+ls);
        ReverseUsingLinkedList(ls);
        System.out.println("After Reversing: "+ls);



    }
}