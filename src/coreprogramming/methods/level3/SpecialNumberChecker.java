package coreprogramming.methods.level3;

import java.util.Scanner;

public class SpecialNumberChecker {

    public static boolean isPrime(int number) {

        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNeonNumber(int number) {

        int square = number * number;
        int sum = 0;

        while (square != 0) {
            sum += square % 10;
            square /= 10;
        }

        return sum == number;
    }

    public static boolean isSpyNumber(int number) {

        int sum = 0;
        int product = 1;
        int temp = number;

        while (temp != 0) {
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }

        return sum == product;
    }

    public static boolean isAutomorphicNumber(int number) {

        int square = number * number;
        int temp = number;

        while (temp != 0) {
            if (temp % 10 != square % 10) {
                return false;
            }
            temp /= 10;
            square /= 10;
        }
        return true;
    }

    public static boolean isBuzzNumber(int number) {

        return (number % 7 == 0) || (number % 10 == 7);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        System.out.println("Prime Number = " +
                (isPrime(number) ? "Yes" : "No"));

        System.out.println("Neon Number = " +
                (isNeonNumber(number) ? "Yes" : "No"));

        System.out.println("Spy Number = " +
                (isSpyNumber(number) ? "Yes" : "No"));

        System.out.println("Automorphic Number = " +
                (isAutomorphicNumber(number) ? "Yes" : "No"));

        System.out.println("Buzz Number = " +
                (isBuzzNumber(number) ? "Yes" : "No"));
    }
}

