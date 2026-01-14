package coreprogramming.methods.level1;

import java.util.Scanner;

public class ChocolateDistributionMethod {

    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int chocolatesEach = number / divisor;
        int remaining = number % divisor;
        return new int[]{chocolatesEach, remaining};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of chocolates: ");
        int chocolates = sc.nextInt();

        System.out.print("Enter number of children: ");
        int children = sc.nextInt();

        int[] result = findRemainderAndQuotient(chocolates, children);

        System.out.println("Each child gets " + result[0] + " chocolates");
        System.out.println("Remaining chocolates = " + result[1]);
    }
}
