package ioprogramming.designpattern;
import java.util.Scanner;

/*
 Bridge Pattern
 Separates abstraction from implementation
*/

// Color interface
interface Color {
    void applyColor();
}

// Red implementation
class Red implements Color {
    public void applyColor() {
        System.out.println("Applying Red color");
    }
}

// Blue implementation
class Blue implements Color {
    public void applyColor() {
        System.out.println("Applying Blue color");
    }
}

// Abstract Shape
abstract class Shape1 {

    protected Color color;

    Shape1(Color color) {
        this.color = color;
    }

    abstract void draw();
}

// Circle
class Circle1 extends Shape1 {

    Circle1(Color color) {
        super(color);
    }

    void draw() {
        System.out.print("Drawing Circle with ");
        color.applyColor();
    }
}

// Square
class Square extends Shape1 {

    Square(Color color) {
        super(color);
    }

    void draw() {
        System.out.print("Drawing Square with ");
        color.applyColor();
    }
}

public class BridgeDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose shape (circle/square):");
        String shapeType = sc.nextLine();

        System.out.println("Choose color (red/blue):");
        String colorType = sc.nextLine();

        Color color = colorType.equalsIgnoreCase("red") ? new Red() : new Blue();

        Shape1 shape;

        if (shapeType.equalsIgnoreCase("circle"))
            shape = new Circle1(color);
        else
            shape = new Square(color);

        shape.draw();
    }
}