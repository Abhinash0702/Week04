package customexception;

import java.util.Scanner;


public class Main {

    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Invalid age",age);
        } else {
            System.out.println("Access granted!");
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try{
            System.out.println("Enter a Age :");
            int age = input.nextInt();
            validateAge(age);
        }
        catch (InvalidAgeException e){
            System.out.println(e.getMessage());
        }
        }
    }

