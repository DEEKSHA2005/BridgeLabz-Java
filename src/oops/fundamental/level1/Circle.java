package oops.fundamental.level1;

import java.util.Scanner;

public class Circle {

    double radius;

    void calculate() {
        double area = Math.PI * radius * radius;
        double circumference = 2 * Math.PI * radius;

        System.out.println("Area of Circle          : " + area);
        System.out.println("Circumference of Circle : " + circumference);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Circle c = new Circle();

        System.out.print("Enter radius: ");
        c.radius = sc.nextDouble();

        c.calculate();
    }
}

