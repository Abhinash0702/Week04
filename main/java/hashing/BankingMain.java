package hashing;

import java.util.*;

class BankingSystem {
    private Map<Integer, Double> accounts = new HashMap<>();
    private TreeMap<Double, Integer> sortedByBalance = new TreeMap<>();
    private Queue<Integer> withdrawalQueue = new LinkedList<>();

    public void createAccount(int accountNumber, double balance) {
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account already exists!");
        } else {
            accounts.put(accountNumber, balance);
            sortedByBalance.put(balance, accountNumber);
            System.out.println("Account created for Account Number: " + accountNumber);
        }
    }

    public void deposit(int accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double newBalance = accounts.get(accountNumber) + amount;
            accounts.put(accountNumber, newBalance);
            sortedByBalance.put(newBalance, accountNumber);
            System.out.println("Deposited " + amount + " to Account Number: " + accountNumber);
        } else {
            System.out.println("Account does not exist!");
        }
    }

    public void withdraw(int accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            if (accounts.get(accountNumber) >= amount) {
                withdrawalQueue.add(accountNumber);
                System.out.println("Withdrawal request added for Account Number: " + accountNumber);
            } else {
                System.out.println("Insufficient balance in Account Number: " + accountNumber);
            }
        } else {
            System.out.println("Account does not exist!");
        }
    }

    public void processWithdrawal() {
        if (!withdrawalQueue.isEmpty()) {
            int accountNumber = withdrawalQueue.poll();
            double amount = 50;
            double currentBalance = accounts.get(accountNumber);
            if (currentBalance >= amount) {
                accounts.put(accountNumber, currentBalance - amount);
                System.out.println("Processed withdrawal of " + amount + " from Account Number: " + accountNumber);
            } else {
                System.out.println("Insufficient balance for withdrawal in Account Number: " + accountNumber);
            }
        } else {
            System.out.println("No withdrawal requests in the queue.");
        }
    }

    public void displaySortedAccounts() {
        if (sortedByBalance.isEmpty()) {
            System.out.println("No accounts available.");
        } else {
            System.out.println("Accounts sorted by balance:");
            for (Map.Entry<Double, Integer> entry : sortedByBalance.entrySet()) {
                System.out.println("Account Number: " + entry.getValue() + ", Balance: " + entry.getKey());
            }
        }
    }
}

public class BankingMain {
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        bank.createAccount(101, 500);
        bank.createAccount(102, 1000);
        bank.createAccount(103, 150);
        bank.deposit(101, 200);
        bank.deposit(103, 50);
        bank.displaySortedAccounts();
        bank.withdraw(101, 50);
        bank.withdraw(102, 100);
        bank.withdraw(103, 30);
        bank.processWithdrawal();
        bank.processWithdrawal();
        bank.processWithdrawal();
    }
}
