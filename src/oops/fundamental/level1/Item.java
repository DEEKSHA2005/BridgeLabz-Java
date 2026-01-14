package oops.fundamental.level1;

import java.util.Scanner;

public class Item {

    int itemCode;
    String itemName;
    double price;

    void display(int quantity) {
        double totalCost = price * quantity;
        System.out.println("Item Code  : " + itemCode);
        System.out.println("Item Name  : " + itemName);
        System.out.println("Price      : " + price);
        System.out.println("Quantity   : " + quantity);
        System.out.println("Total Cost : " + totalCost);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Item item = new Item();

        System.out.print("Enter item code: ");
        item.itemCode = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter item name: ");
        item.itemName = sc.nextLine();

        System.out.print("Enter price: ");
        item.price = sc.nextDouble();

        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        item.display(quantity);
    }
}
