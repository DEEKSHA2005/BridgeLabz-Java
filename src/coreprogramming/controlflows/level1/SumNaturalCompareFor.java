package coreprogramming.controlflows.level1;

import java.util.Scanner;

public class SumNaturalCompareFor {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();

        if (n > 0) {
            int sumFor = 0;

            for (int i = 1; i <= n; i++) {
                sumFor += i;
            }

            int sumFormula = n * (n + 1) / 2;

            System.out.println("Sum using for loop is " + sumFor);
            System.out.println("Sum using formula is " + sumFormula);
        } else {
            System.out.println("Not a natural number");
        }
    }
}

