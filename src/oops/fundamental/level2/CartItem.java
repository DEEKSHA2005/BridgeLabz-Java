package oops.fundamental.level2;

import java.util.Scanner;

public class CartItem {

    String itemName;
    double price;
    int quantity;

    void addItem(int qty) {
        quantity += qty;
        System.out.println(qty + " item(s) added to cart.");
    }

    void removeItem(int qty) {
        if (qty <= quantity) {
            quantity -= qty;
            System.out.println(qty + " item(s) removed from cart.");
        } else {
            System.out.println("Not enough items to remove.");
        }
    }

    void displayTotalCost() {
        double totalCost = price * quantity;
        System.out.println("Item Name  : " + itemName);
        System.out.println("Price      : " + price);
        System.out.println("Quantity   : " + quantity);
        System.out.println("Total Cost : " + totalCost);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CartItem cart = new CartItem();

        System.out.print("Enter item name: ");
        cart.itemName = sc.nextLine();

        System.out.print("Enter price: ");
        cart.price = sc.nextDouble();

        System.out.print("Enter quantity to add: ");
        int addQty = sc.nextInt();
        cart.addItem(addQty);

        System.out.print("Enter quantity to remove: ");
        int removeQty = sc.nextInt();
        cart.removeItem(removeQty);

        cart.displayTotalCost();
    }
}

