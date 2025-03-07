package uncheckedexception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UncheckedException {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {
        System.out.println("Enter first Number : ");
        int num1 = input.nextInt();
        System.out.println("Enter second Number : ");
        int num2 = input.nextInt();
        int result = num1 / num2;
        System.out.println(result);

        } catch (ArithmeticException e) {
            System.out.println(" Division by zero is not allowed.");
        }
        catch (InputMismatchException e){
            System.out.println(" Enter a valid integer.");
        }

    }
}
