package dsa.linearbinary;

import java.util.Scanner;

public class Reverse {

    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String result = reverseString(input);
        System.out.println("Reversed string: " + result);

        sc.close();
    }
}
