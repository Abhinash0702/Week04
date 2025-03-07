package multiplecatchblocks;

import java.util.Scanner;

public class MultipleCatchBlocks {



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Size of Array: ");
        int size = input.nextInt();
        int[] arr = new int [size];

        System.out.println("Enter Array Elements : ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.nextInt();
        }


        try{
            System.out.println("Enter Index : ");
            int index = input.nextInt();
            System.out.println("Value at Index "+index+" : "+arr[index]);

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Enter Valid Index");
        } catch (NullPointerException e) {
            System.out.println("Array Is Null");
        }

    }




}
