package coreprogramming.methods.level1;

import java.util.Scanner;

public class NumberCheckMethod {

    public static String checkNumber(int number) {
        if (number > 0) {
            return "Positive";
        } else if (number < 0) {
            return "Negative";
        } else {
            return "Zero";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        String result = checkNumber(number);

        System.out.println("The number " + number + " is " + result);
    }
}
