package collectionstreams.regex.advanced.bank;

public class BankAccount {

    private double balance = 0;


    public void deposit(double amount) {
        balance += amount;
    }


    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
    }


    public double getBalance() {
        return balance;
    }
}
