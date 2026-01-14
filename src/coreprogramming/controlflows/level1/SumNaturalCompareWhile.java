package coreprogramming.controlflows.level1;

import java.util.Scanner;

public class SumNaturalCompareWhile {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();

        if (n > 0) {
            int sumWhile = 0;
            int i = 1;

            while (i <= n) {
                sumWhile += i;
                i++;
            }

            int sumFormula = n * (n + 1) / 2;

            System.out.println("Sum using while loop is " + sumWhile);
            System.out.println("Sum using formula is " + sumFormula);
            System.out.println("Both results are equal: " + (sumWhile == sumFormula));
        } else {
            System.out.println("Not a natural number");
        }
    }
}

