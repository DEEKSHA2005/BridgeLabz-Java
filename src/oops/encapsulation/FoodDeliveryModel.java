package oops.encapsulation;

import java.util.Scanner;

interface Deliverable {
    void deliver();
}

abstract class FoodOrder {
    protected String itemName;

    public FoodOrder(String itemName) {
        this.itemName = itemName;
    }

    abstract void prepareFood();
}

class RestaurantOrder extends FoodOrder implements Deliverable {

    public RestaurantOrder(String itemName) {
        super(itemName);
    }

    void prepareFood() {
        System.out.println("Preparing " + itemName);
    }

    public void deliver() {
        System.out.println(itemName + " delivered");
    }
}

public class FoodDeliveryModel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter food item: ");
        String item = sc.nextLine();

        FoodOrder order = new RestaurantOrder(item);
        order.prepareFood();
        ((Deliverable) order).deliver();
    }
}
