package coreprogramming.arrays.level2;

import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        long number = sc.nextLong();

        int[] frequency = new int[10];

        while (number != 0) {
            int digit = (int)(number % 10);
            frequency[digit]++;
            number = number / 10;
        }

        for (int i = 0; i < frequency.length; i++) {
            System.out.println("Digit " + i + " occurs " + frequency[i] + " times");
        }
    }
}

