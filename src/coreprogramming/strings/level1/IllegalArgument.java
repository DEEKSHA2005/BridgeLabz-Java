package coreprogramming.strings.level1;

import java.util.Scanner;

public class IllegalArgument {

    public static void generateException(String text) {

        System.out.println(text.substring(5, 2));
    }

    public static void handleException(String text) {

        try {
            System.out.println(text.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException handled successfully");
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

