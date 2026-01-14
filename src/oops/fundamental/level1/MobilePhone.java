package oops.fundamental.level1;

import java.util.Scanner;

public class MobilePhone {

    String brand;
    String model;
    double price;

    void display() {
        System.out.println("Brand : " + brand);
        System.out.println("Model : " + model);
        System.out.println("Price : " + price);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MobilePhone phone = new MobilePhone();

        System.out.print("Enter brand: ");
        phone.brand = sc.nextLine();

        System.out.print("Enter model: ");
        phone.model = sc.nextLine();

        System.out.print("Enter price: ");
        phone.price = sc.nextDouble();

        phone.display();
    }
}

