package list_interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem03_RotateElements {
    public static void rotateList(List<Integer> list){
        int temp=list.get(0);
        for(int i=0;i<list.size()-1;i++){
            list.set(i,list.get(i+1));
        }
        list.set(list.size()-1,temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list= new ArrayList<>(Arrays.asList(10,20,30,40,50));
        int k=2;
        System.out.println("List before Rotation"+list);
        while(k-- > 0){
            rotateList(list);
        }
        System.out.println("List after rotation"+list);
    }
}
