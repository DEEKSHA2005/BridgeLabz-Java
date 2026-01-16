package oops.inheritance;

class Vehicle {
    int maxSpeed;
    String fuelType;

    Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    void displayInfo() {
        System.out.println("Speed: " + maxSpeed + ", Fuel: " + fuelType);
    }
}

class Car extends Vehicle {
    int seatCapacity;

    Car(int speed, String fuel, int seats) {
        super(speed, fuel);
        seatCapacity = seats;
    }

    @Override
    void displayInfo() {
        System.out.println("Car - Seats: " + seatCapacity);
    }
}

class Truck extends Vehicle {
    int loadCapacity;

    Truck(int speed, String fuel, int load) {
        super(speed, fuel);
        loadCapacity = load;
    }

    @Override
    void displayInfo() {
        System.out.println("Truck - Load: " + loadCapacity);
    }
}

public class VehicleModel {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[2];
        vehicles[0] = new Car(180, "Petrol", 5);
        vehicles[1] = new Truck(120, "Diesel", 1000);

        for (Vehicle v : vehicles) {
            v.displayInfo(); // polymorphism
        }
    }
}

