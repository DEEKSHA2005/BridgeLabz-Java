package coreprogramming.strings.level1;

import java.util.Scanner;

public class StringIndexOutOfBounds {

    public static void generateException(String text) {

        System.out.println(text.charAt(text.length()));
    }

    public static void handleException(String text) {

        try {
            System.out.println(text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException handled successfully");
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
