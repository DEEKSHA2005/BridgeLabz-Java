package oops.statics.level1;

import java.util.Scanner;

public class Vehicle {

    private static double registrationFee;

    private String ownerName;
    private String vehicleType;
    private final String registrationNumber;

    public Vehicle(String owner, String type, String regNo) {
        this.ownerName = owner;
        this.vehicleType = type;
        this.registrationNumber = regNo;
    }

    public static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }

    public void display() {
        System.out.println("Owner     : " + ownerName);
        System.out.println("Vehicle   : " + vehicleType);
        System.out.println("Reg No    : " + registrationNumber);
        System.out.println("Fee       : " + registrationFee);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter registration fee: ");
        updateRegistrationFee(sc.nextDouble());
        sc.nextLine();

        System.out.print("Enter owner name: ");
        String o = sc.nextLine();

        System.out.print("Enter vehicle type: ");
        String v = sc.nextLine();

        System.out.print("Enter registration number: ");
        String r = sc.nextLine();

        Object obj = new Vehicle(o, v, r);

        if (obj instanceof Vehicle) {
            Vehicle ve = (Vehicle) obj;
            ve.display();
        }
    }
}

