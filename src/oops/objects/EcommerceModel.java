package oops.objects;

import java.util.ArrayList;
import java.util.Scanner;

class Product {
    String name;

    Product(String name) {
        this.name = name;
    }
}

class Order {
    ArrayList<Product> products = new ArrayList<>();

    void addProduct(Product p) {
        products.add(p);
    }

    void showProducts() {
        for (Product p : products) {
            System.out.println("- " + p.name);
        }
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }

    void placeOrder(Order o) {
        System.out.println(name + " placed an order:");
        o.showProducts();
    }
}

public class EcommerceModel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        Customer c = new Customer(sc.nextLine());

        Order o = new Order();

        System.out.print("Enter first product: ");
        o.addProduct(new Product(sc.nextLine()));

        System.out.print("Enter second product: ");
        o.addProduct(new Product(sc.nextLine()));

        c.placeOrder(o);
    }
}
