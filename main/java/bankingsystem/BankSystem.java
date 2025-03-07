package bankingsystem;

import java.util.Scanner;

public class BankSystem {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        BankAccount account = new BankAccount(10000);

        System.out.println("Enter withdrawal amount :");
        double amount = input.nextDouble();

        try{
            account.withdraw(amount);
        }catch (InsufficientBalanceException e){
            System.out.println(e);
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }



    }
}
