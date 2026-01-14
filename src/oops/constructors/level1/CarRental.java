package oops.constructors.level1;

import java.util.Scanner;

public class CarRental {

    private String customerName;
    private String carModel;
    private int rentalDays;
    private final int costPerDay = 1000;

    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    public String getCustomerName() { return customerName; }
    public String getCarModel() { return carModel; }
    public int getRentalDays() { return rentalDays; }

    public void calculateTotalCost() {
        int totalCost = rentalDays * costPerDay;
        System.out.println("Customer Name : " + getCustomerName());
        System.out.println("Car Model     : " + getCarModel());
        System.out.println("Rental Days   : " + getRentalDays());
        System.out.println("Total Cost    : " + totalCost);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String c = sc.nextLine();

        System.out.print("Enter car model: ");
        String m = sc.nextLine();

        System.out.print("Enter rental days: ");
        int d = sc.nextInt();

        CarRental r = new CarRental(c, m, d);
        r.calculateTotalCost();
    }
}

