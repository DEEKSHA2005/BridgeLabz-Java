package coreprogramming.strings.extras1;

import java.util.Scanner;

public class ReverseString {

    public static String reverseString(String text) {

        String reversed = "";

        for (int i = text.length() - 1; i >= 0; i--) {
            reversed = reversed + text.charAt(i);
        }

        return reversed;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String result = reverseString(input);

        System.out.println("Reversed String: " + result);
    }
}
