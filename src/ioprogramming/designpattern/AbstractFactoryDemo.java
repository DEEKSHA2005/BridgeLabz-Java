package ioprogramming.designpattern;
import java.util.Scanner;

/* Car interface */
interface Car {
    void createCar();
}

/* Bike interface */
interface Bike {
    void createBike();
}

// Sedan class
class Sedan implements Car {
    public void createCar() {
        System.out.println("Sedan car created");
    }
}

// SUV class
class SUV implements Car {
    public void createCar() {
        System.out.println("SUV car created");
    }
}

// SportsBike class
class SportsBike implements Bike {
    public void createBike() {
        System.out.println("Sports Bike created");
    }
}

// NormalBike class
class NormalBike implements Bike {
    public void createBike() {
        System.out.println("Normal Bike created");
    }
}

/* Abstract factory */
interface VehicleFactory {
    Car getCar(String type);
    Bike getBike(String type);
}

// Car factory
class CarFactory implements VehicleFactory {

    public Car getCar(String type) {

        if (type.equalsIgnoreCase("sedan"))
            return new Sedan();

        if (type.equalsIgnoreCase("suv"))
            return new SUV();

        return null;
    }

    public Bike getBike(String type) {
        return null;
    }
}

// Bike factory
class BikeFactory implements VehicleFactory {

    public Bike getBike(String type) {

        if (type.equalsIgnoreCase("sports"))
            return new SportsBike();

        if (type.equalsIgnoreCase("normal"))
            return new NormalBike();

        return null;
    }

    public Car getCar(String type) {
        return null;
    }
}

public class AbstractFactoryDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose vehicle type (car/bike):");
        String choice = sc.nextLine();

        if (choice.equalsIgnoreCase("car")) {

            System.out.println("Enter car type (sedan/suv):");
            String type = sc.nextLine();

            VehicleFactory factory = new CarFactory();
            Car car = factory.getCar(type);
            car.createCar();
        }

        else if (choice.equalsIgnoreCase("bike")) {

            System.out.println("Enter bike type (sports/normal):");
            String type = sc.nextLine();

            VehicleFactory factory = new BikeFactory();
            Bike bike = factory.getBike(type);
            bike.createBike();
        }
    }
}
