package coreprogramming.strings.extras2;

import java.util.Scanner;

public class GCDLCMCalculator {

    public static int findGCD(int a, int b) {
        if (b == 0)
            return a;
        return findGCD(b, a % b);
    }

    public static int findLCM(int a, int b) {
        return (a * b) / findGCD(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("GCD = " + findGCD(a, b));
        System.out.println("LCM = " + findLCM(a, b));
    }
}
