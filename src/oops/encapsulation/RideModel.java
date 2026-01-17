package oops.encapsulation;

import java.util.Scanner;

interface Ride {
    double calculateFare(int km);
}

abstract class VehicleRide {
    protected String vehicleType;

    public VehicleRide(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    abstract void displayRide();
}

class CabRide extends VehicleRide implements Ride {

    public CabRide(String vehicleType) {
        super(vehicleType);
    }

    public double calculateFare(int km) {
        return km * 15;
    }

    void displayRide() {
        System.out.println("Vehicle Type: " + vehicleType);
    }
}

public class RideModel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter vehicle type: ");
        String type = sc.nextLine();
        System.out.print("Enter distance (km): ");
        int km = sc.nextInt();

        VehicleRide ride = new CabRide(type);
        ride.displayRide();
        System.out.println("Fare: " + ((Ride) ride).calculateFare(km));
    }
}

