package objectorientedprogramming.statics.level1;

import java.util.Scanner;

public class Product {

    private static double discount;

    private final int productID;
    private String productName;
    private double price;
    private int quantity;

    public Product(int id, String name, double price, int qty) {
        this.productID = id;
        this.productName = name;
        this.price = price;
        this.quantity = qty;
    }

    public static void updateDiscount(double d) {
        discount = d;
    }

    public void display() {
        double total = price * quantity;
        double finalAmount = total - (total * discount / 100);

        System.out.println("Product ID : " + productID);
        System.out.println("Name       : " + productName);
        System.out.println("Final Cost : " + finalAmount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter discount %: ");
        updateDiscount(sc.nextDouble());

        System.out.print("Enter product id: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter product name: ");
        String n = sc.nextLine();

        System.out.print("Enter price: ");
        double p = sc.nextDouble();

        System.out.print("Enter quantity: ");
        int q = sc.nextInt();

        Object obj = new Product(id, n, p, q);

        if (obj instanceof Product) {
            Product pr = (Product) obj;
            pr.display();
        }
    }
}
