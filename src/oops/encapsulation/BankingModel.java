package oops.encapsulation;

import java.util.Scanner;

interface Interest {
    double calculateInterest();
}

abstract class Account {
    protected double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    abstract void displayAccount();
}

class SavingsAccount extends Account implements Interest {

    public SavingsAccount(double balance) {
        super(balance);
    }

    public double calculateInterest() {
        return balance * 0.05;
    }

    void displayAccount() {
        System.out.println("Balance  : " + balance);
        System.out.println("Interest : " + calculateInterest());
    }
}

public class BankingModel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter balance: ");
        double balance = sc.nextDouble();

        Account acc = new SavingsAccount(balance);
        acc.displayAccount();
    }
}

