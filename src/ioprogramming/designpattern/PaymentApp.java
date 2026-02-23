package ioprogramming.designpattern;
import java.util.Scanner;

/*
 Strategy Pattern
 Choose algorithm at runtime
*/

interface PaymentMethod {
    void pay(int amount);
}

class CashMode implements PaymentMethod {

    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Cash");
    }
}

class CardMode implements PaymentMethod {

    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Card");
    }
}

class UpiMode implements PaymentMethod {

    public void pay(int amount) {
        System.out.println("Paid " + amount + " using UPI");
    }
}

class Checkout {

    PaymentMethod method;

    Checkout(PaymentMethod method) {
        this.method = method;
    }

    void makePayment(int amount) {
        method.pay(amount);
    }
}

public class PaymentApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter payment type (cash/card/upi):");
        String type = sc.nextLine();

        System.out.println("Enter amount:");
        int amt = sc.nextInt();

        PaymentMethod method;

        if (type.equalsIgnoreCase("cash"))
            method = new CashMode();
        else if (type.equalsIgnoreCase("card"))
            method = new CardMode();
        else
            method = new UpiMode();

        Checkout co = new Checkout(method);
        co.makePayment(amt);
    }
}
