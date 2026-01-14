package coreprogramming.strings.level1;

import java.util.Scanner;

public class ArrayIndexOutOfBounds {

    public static void generateException(String[] names) {

        System.out.println(names[names.length]);
    }

    public static void handleException(String[] names) {

        try {
            System.out.println(names[names.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException handled successfully");
        } catch (RuntimeException e) {
            System.out.println("Generic RuntimeException handled");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of names: ");
        int n = sc.nextInt();

        String[] names = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = sc.next();
        }

        try {
            generateException(names);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e);
        }

        handleException(names);
    }
}

