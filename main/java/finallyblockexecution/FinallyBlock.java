package finallyblockexecution;

import java.util.Scanner;

public class FinallyBlock {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter First number :");
        int num1 = input.nextInt();
        System.out.println("Enter second number :");
        int num2 = input.nextInt();

        try{
            System.out.println("Division result : "+(num1/num2));
        }catch (ArithmeticException e){
            System.out.println("Division with zero is not allowed.");
        }finally {
            System.out.println("Operation completed");
        }
    }
}
