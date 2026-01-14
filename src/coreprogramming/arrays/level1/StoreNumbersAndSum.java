package coreprogramming.arrays.level1;

import java.util.Scanner;

public class StoreNumbersAndSum {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;

        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double value = sc.nextDouble();

            if (value <= 0 || index == numbers.length) {
                break;
            }

            numbers[index] = value;
            index++;
        }

        System.out.println("Stored Numbers:");
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
            total += numbers[i];
        }

        System.out.println("Total Sum = " + total);
    }
}

