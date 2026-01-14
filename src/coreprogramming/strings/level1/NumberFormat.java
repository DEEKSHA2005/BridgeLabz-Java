package coreprogramming.strings.level1;

import java.util.Scanner;

public class NumberFormat {

    public static void generateException(String text) {

        int number = Integer.parseInt(text);
        System.out.println("Number is: " + number);
    }

    public static void handleException(String text) {

        try {
            int number = Integer.parseInt(text);
            System.out.println("Number is: " + number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException handled successfully");
        } catch (RuntimeException e) {
            System.out.println("Generic RuntimeException handled");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        try {
            generateException(text);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e);
        }

        handleException(text);
    }
}

