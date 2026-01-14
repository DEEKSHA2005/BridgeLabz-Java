package coreprogramming.controlflows.level2;

import java.util.Scanner;

public class MultiplesBelow100While {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        if (number > 0 && number < 100) {
            int i = number;
            System.out.println("Multiples of " + number + " below 100 are:");

            while (i < 100) {
                System.out.println(i);
                i += number;
            }
        } else {
            System.out.println("Please enter a positive number less than 100");
        }
    }
}

