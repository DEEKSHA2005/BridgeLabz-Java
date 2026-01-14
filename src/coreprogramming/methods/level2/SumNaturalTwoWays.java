package coreprogramming.methods.level2;

import java.util.Scanner;

public class SumNaturalTwoWays {

    public static int sumUsingFormula(int n) {
        return n * (n + 1) / 2;
    }

    public static int sumUsingLoop(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.println("Sum using formula = " + sumUsingFormula(n));
        System.out.println("Sum using loop = " + sumUsingLoop(n));
    }
}
