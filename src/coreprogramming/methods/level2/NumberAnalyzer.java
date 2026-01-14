package coreprogramming.methods.level2;

import java.util.Scanner;

public class NumberAnalyzer {

    public static boolean isPositive(int number) {
        return number >= 0;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int compare(int number1, int number2) {
        if (number1 > number2) {
            return 1;
        } else if (number1 == number2) {
            return 0;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        // Take input
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }

        System.out.println("\n--- Number Analysis ---");

        for (int i = 0; i < numbers.length; i++) {

            int num = numbers[i];

            if (isPositive(num)) {
                if (isEven(num)) {
                    System.out.println("Number " + (i + 1) + " is Positive and Even");
                } else {
                    System.out.println("Number " + (i + 1) + " is Positive and Odd");
                }
            } else {
                System.out.println("Number " + (i + 1) + " is Negative");
            }
        }

        int result = compare(numbers[0], numbers[numbers.length - 1]);

        if (result == 1) {
            System.out.println("First element is greater than last element");
        } else if (result == 0) {
            System.out.println("First element is equal to last element");
        } else {
            System.out.println("First element is less than last element");
        }
    }
}

