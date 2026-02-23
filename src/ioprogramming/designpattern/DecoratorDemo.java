package ioprogramming.designpattern;
import java.util.Scanner;

/*
 Decorator Pattern
 Adds functionality dynamically
*/

// Coffee interface
interface Coffee {
    double cost();
}

// Simple coffee
class SimpleCoffee implements Coffee {

    public double cost() {
        return 50;
    }
}

// Abstract decorator
abstract class CoffeeDecorator implements Coffee {

    Coffee coffee;

    CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}

// Milk decorator
class MilkDecorator extends CoffeeDecorator {

    MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public double cost() {
        return coffee.cost() + 20;
    }
}

// Sugar decorator
class SugarDecorator extends CoffeeDecorator {

    SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    public double cost() {
        return coffee.cost() + 10;
    }
}

public class DecoratorDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Coffee coffee = new SimpleCoffee();

        System.out.println("Add milk? (yes/no)");
        String milk = sc.nextLine();

        if (milk.equalsIgnoreCase("yes"))
            coffee = new MilkDecorator(coffee);

        System.out.println("Add sugar? (yes/no)");
        String sugar = sc.nextLine();

        if (sugar.equalsIgnoreCase("yes"))
            coffee = new SugarDecorator(coffee);

        System.out.println("Total coffee cost: " + coffee.cost());
    }
}
