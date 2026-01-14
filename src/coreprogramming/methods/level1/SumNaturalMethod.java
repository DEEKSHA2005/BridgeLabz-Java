package coreprogramming.methods.level1;

import java.util.Scanner;

public class SumNaturalMethod {

    public static int sumOfNaturalNumbers(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int number = sc.nextInt();

        if (number > 0) {
            int sum = sumOfNaturalNumbers(number);
            System.out.println("The sum of " + number +
                    " natural numbers is " + sum);
        } else {
            System.out.println("Not a natural number");
        }
    }
}
