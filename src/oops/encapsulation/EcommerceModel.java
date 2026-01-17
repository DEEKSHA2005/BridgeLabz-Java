package oops.encapsulation;

import java.util.Scanner;

interface Payment {
    void makePayment(double amount);
}

abstract class Order {
    protected double amount;

    public Order(double amount) {
        this.amount = amount;
    }

    abstract void processOrder();
}

class OnlineOrder extends Order implements Payment {

    public OnlineOrder(double amount) {
        super(amount);
    }

    public void makePayment(double amount) {
        System.out.println("Payment of " + amount + " successful");
    }

    void processOrder() {
        makePayment(amount);
        System.out.println("Online order processed");
    }
}

public class EcommerceModel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter order amount: ");
        double amount = sc.nextDouble();

        Order order = new OnlineOrder(amount);
        order.processOrder();
    }
}

