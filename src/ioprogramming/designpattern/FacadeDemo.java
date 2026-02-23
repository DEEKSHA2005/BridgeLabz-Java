package ioprogramming.designpattern;
import java.util.Scanner;

/*
 Facade Pattern
 Provides simplified interface to complex system
*/

class AccountService {
    void checkAccount() {
        System.out.println("Account verified");
    }
}

class BalanceService {
    void checkBalance() {
        System.out.println("Balance checked");
    }
}

class TransactionService {
    void makeTransaction() {
        System.out.println("Transaction successful");
    }
}

// Facade class
class BankFacade {

    AccountService account = new AccountService();
    BalanceService balance = new BalanceService();
    TransactionService transaction = new TransactionService();

    void withdraw() {
        account.checkAccount();
        balance.checkBalance();
        transaction.makeTransaction();
    }
}

public class FacadeDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter withdrawal amount:");
        int amount = sc.nextInt();

        BankFacade bank = new BankFacade();

        System.out.println("Processing withdrawal of " + amount);
        bank.withdraw();
    }
}