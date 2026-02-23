package ioprogramming.designpattern;
import java.util.Scanner;

/* Shape interface */
interface Shape {
    void draw();
}

// Circle class
class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

// Rectangle class
class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

/* Factory class */
class ShapeFactory {

    // static factory method
    public static Shape getShape(String type) {

        if (type.equalsIgnoreCase("circle"))
            return new Circle();

        else if (type.equalsIgnoreCase("rectangle"))
            return new Rectangle();

        return null;
    }
}

public class FactoryDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // user input
        System.out.println("Enter shape type (circle/rectangle):");
        String type = sc.nextLine();

        // factory call
        Shape s = ShapeFactory.getShape(type);

        if (s != null)
            s.draw();
        else
            System.out.println("Invalid shape type");
    }
}
