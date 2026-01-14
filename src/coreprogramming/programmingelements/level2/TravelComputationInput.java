package coreprogramming.programmingelements.level2;

import java.util.Scanner;

public class TravelComputationInput {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter traveler name: ");
        String name = sc.nextLine();

        System.out.print("Enter from city: ");
        String fromCity = sc.nextLine();

        System.out.print("Enter via city: ");
        String viaCity = sc.nextLine();

        System.out.print("Enter to city: ");
        String toCity = sc.nextLine();

        System.out.print("Enter distance from " + fromCity + " to " + viaCity + ": ");
        double distanceFromToVia = sc.nextDouble();

        System.out.print("Enter distance from " + viaCity + " to " + toCity + ": ");
        double distanceViaToFinalCity = sc.nextDouble();

        System.out.print("Enter time from " + fromCity + " to " + viaCity + " (in minutes): ");
        int timeFromToVia = sc.nextInt();

        System.out.print("Enter time from " + viaCity + " to " + toCity + " (in minutes): ");
        int timeViaToFinalCity = sc.nextInt();

        double totalDistance = distanceFromToVia + distanceViaToFinalCity;
        int totalTime = timeFromToVia + timeViaToFinalCity;

        System.out.println("The Total Distance travelled by " + name + " from " +
                fromCity + " to " + toCity + " via " + viaCity +
                " is " + totalDistance + " km and " +
                "the Total Time taken is " + totalTime + " minutes");
    }
}

