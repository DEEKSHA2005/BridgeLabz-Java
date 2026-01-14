package coreprogramming.controlflows.level3;

import java.util.Scanner;

public class LeapYearCheck {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter year: ");
        int year = sc.nextInt();

        if (year >= 1582) {
            if (year % 400 == 0) {
                System.out.println("Year " + year + " is a Leap Year");
            } else if (year % 100 == 0) {
                System.out.println("Year " + year + " is not a Leap Year");
            } else if (year % 4 == 0) {
                System.out.println("Year " + year + " is a Leap Year");
            } else {
                System.out.println("Year " + year + " is not a Leap Year");
            }
        } else {
            System.out.println("Year should be greater than or equal to 1582");
        }
    }
}
