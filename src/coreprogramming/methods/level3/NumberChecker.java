package coreprogramming.methods.level3;

import java.util.Scanner;

public class NumberChecker {

    public static boolean isDuckNumber(int number) {

        if (number <= 0) {
            return false;
        }

        while (number != 0) {
            if (number % 10 == 0) {
                return true;
            }
            number = number / 10;
        }
        return false;
    }

    public static boolean isArmstrongNumber(int number) {

        int original = number;
        int digits = 0;
        int temp = number;

        while (temp != 0) {
            digits++;
            temp /= 10;
        }

        int sum = 0;
        temp = number;

        while (temp != 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, digits);
            temp /= 10;
        }

        return sum == original;
    }

    public static int[] extractDigits(int number) {

        int temp = number;
        int count = 0;

        while (temp != 0) {
            count++;
            temp /= 10;
        }

        int[] digits = new int[count];
        temp = number;

        for (int i = count - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }

        return digits;
    }

    public static int[] findLargestAndSecondLargest(int[] digits) {

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < digits.length; i++) {

            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        return new int[]{largest, secondLargest};
    }

    public static int[] findSmallestAndSecondSmallest(int[] digits) {

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int i = 0; i < digits.length; i++) {

            if (digits[i] < smallest) {
                secondSmallest = smallest;
                smallest = digits[i];
            } else if (digits[i] < secondSmallest && digits[i] != smallest) {
                secondSmallest = digits[i];
            }
        }

        return new int[]{smallest, secondSmallest};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        System.out.println("Duck Number: " +
                (isDuckNumber(number) ? "Yes" : "No"));

        System.out.println("Armstrong Number: " +
                (isArmstrongNumber(number) ? "Yes" : "No"));

        int[] digits = extractDigits(number);

        int[] large = findLargestAndSecondLargest(digits);
        int[] small = findSmallestAndSecondSmallest(digits);

        System.out.println("Largest Digit = " + large[0]);
        System.out.println("Second Largest Digit = " + large[1]);
        System.out.println("Smallest Digit = " + small[0]);
        System.out.println("Second Smallest Digit = " + small[1]);
    }
}


