package coreprogramming.controlflows.level1;

import java.util.Scanner;

public class PositiveNegativeZero {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        if (number > 0) {
            System.out.println("The number " + number + " is positive");
        } else if (number < 0) {
            System.out.println("The number " + number + " is negative");
        } else {
            System.out.println("The number " + number + " is zero");
        }
    }
}

