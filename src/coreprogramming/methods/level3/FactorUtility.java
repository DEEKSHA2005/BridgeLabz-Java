package coreprogramming.methods.level3;

import java.util.Scanner;

public class FactorUtility {

    public static int[] findFactors(int number) {

        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        int[] factors = new int[count];
        int index = 0;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }
        return factors;
    }

    public static int findGreatestFactor(int[] factors) {

        int max = factors[0];
        for (int factor : factors) {
            if (factor > max) {
                max = factor;
            }
        }
        return max;
    }

    public static int sumOfFactors(int[] factors) {

        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    public static long productOfFactors(int[] factors) {

        long product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    public static double productOfCubeOfFactors(int[] factors) {

        double product = 1;
        for (int factor : factors) {
            product *= Math.pow(factor, 3);
        }
        return product;
    }

    public static boolean isPerfectNumber(int number, int[] factors) {

        int sum = 0;
        for (int factor : factors) {
            if (factor != number) {
                sum += factor;
            }
        }
        return sum == number;
    }

    public static boolean isAbundantNumber(int number, int[] factors) {

        int sum = 0;
        for (int factor : factors) {
            if (factor != number) {
                sum += factor;
            }
        }
        return sum > number;
    }

    public static boolean isDeficientNumber(int number, int[] factors) {

        int sum = 0;
        for (int factor : factors) {
            if (factor != number) {
                sum += factor;
            }
        }
        return sum < number;
    }

    public static boolean isStrongNumber(int number) {

        int temp = number;
        int sum = 0;

        while (temp != 0) {
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }
        return sum == number;
    }

    public static int factorial(int num) {

        int fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] factors = findFactors(number);

        System.out.print("Factors: ");
        for (int f : factors) {
            System.out.print(f + " ");
        }

        System.out.println("\nGreatest Factor = " + findGreatestFactor(factors));
        System.out.println("Sum of Factors = " + sumOfFactors(factors));
        System.out.println("Product of Factors = " + productOfFactors(factors));
        System.out.println("Product of Cube of Factors = " + productOfCubeOfFactors(factors));

        System.out.println("Perfect Number = " +
                (isPerfectNumber(number, factors) ? "Yes" : "No"));
        System.out.println("Abundant Number = " +
                (isAbundantNumber(number, factors) ? "Yes" : "No"));
        System.out.println("Deficient Number = " +
                (isDeficientNumber(number, factors) ? "Yes" : "No"));
        System.out.println("Strong Number = " +
                (isStrongNumber(number) ? "Yes" : "No"));
    }
}

