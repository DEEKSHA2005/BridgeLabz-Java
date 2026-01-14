package oops.statics.level1;

import java.util.Scanner;

public class BankAccount {

    private static String bankName;
    private static int totalAccounts = 0;

    private String accountHolderName;
    private final int accountNumber;

    public BankAccount(String name, int accNo) {
        this.accountHolderName = name;
        this.accountNumber = accNo;
        totalAccounts++;
    }

    public static void setBankName(String name) {
        bankName = name;
    }

    public static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }

    public void display() {
        System.out.println("Bank Name   : " + bankName);
        System.out.println("Holder Name : " + accountHolderName);
        System.out.println("Account No  : " + accountNumber);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter bank name: ");
        BankAccount.setBankName(sc.nextLine());

        System.out.print("Enter holder name: ");
        String name = sc.nextLine();

        System.out.print("Enter account number: ");
        int acc = sc.nextInt();

        Object obj = new BankAccount(name, acc);

        if (obj instanceof BankAccount) {
            BankAccount b = (BankAccount) obj;
            b.display();
            BankAccount.getTotalAccounts();
        }
    }
}
