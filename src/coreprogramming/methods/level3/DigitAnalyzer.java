package coreprogramming.methods.level3;

import java.util.Scanner;

public class DigitAnalyzer {

    public static int countDigits(int number) {
        int count = 0;

        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    public static int[] storeDigits(int number) {

        int count = countDigits(number);
        int[] digits = new int[count];

        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    public static int sumOfDigits(int[] digits) {

        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    public static int sumOfSquaresOfDigits(int[] digits) {

        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }
        return sum;
    }

    public static boolean isHarshadNumber(int number, int[] digits) {

        int sum = sumOfDigits(digits);
        return number % sum == 0;
    }

    public static int[][] digitFrequency(int[] digits) {

        int[][] frequency = new int[10][2];

        for (int i = 0; i < 10; i++) {
            frequency[i][0] = i;
            frequency[i][1] = 0;
        }

        for (int digit : digits) {
            frequency[digit][1]++;
        }

        return frequency;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] digits = storeDigits(number);

        System.out.println("Digit Count = " + countDigits(number));
        System.out.println("Sum of Digits = " + sumOfDigits(digits));
        System.out.println("Sum of Squares of Digits = " + sumOfSquaresOfDigits(digits));
        System.out.println("Harshad Number = " +
                (isHarshadNumber(number, digits) ? "Yes" : "No"));

        int[][] freq = digitFrequency(digits);

        for (int i = 0; i < freq.length; i++) {
            System.out.println(freq[i][0] + "      " + freq[i][1]);
        }
    }
}

