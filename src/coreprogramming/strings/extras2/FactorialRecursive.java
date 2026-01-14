package coreprogramming.strings.extras2;

import java.util.Scanner;

public class FactorialRecursive {

    public static int factorial(int n) {
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = sc.nextInt();

        System.out.println("Factorial = " + factorial(n));
    }
}
