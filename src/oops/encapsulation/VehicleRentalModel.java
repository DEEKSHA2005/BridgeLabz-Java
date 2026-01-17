package oops.encapsulation;

import java.util.Scanner;

interface Rentable {
    double calculateRent(int days);
}

abstract class Vehicle {
    private String model;

    public Vehicle(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    abstract void showDetails();
}

class Car extends Vehicle implements Rentable {

    public Car(String model) {
        super(model);
    }

    public double calculateRent(int days) {
        return days * 1000;
    }

    void showDetails() {
        System.out.println("Car Model : " + getModel());
    }
}

public class VehicleRentalModel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter car model: ");
        String model = sc.nextLine();
        System.out.print("Enter days: ");
        int days = sc.nextInt();

        Vehicle v = new Car(model);
        v.showDetails();
        System.out.println("Total Rent : " + ((Rentable) v).calculateRent(days));
    }
}

