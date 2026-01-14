package coreprogramming.programmingelements.level2;

import java.util.Scanner;

public class ChocolateDistribution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of chocolates: ");
        int chocolates = sc.nextInt();

        System.out.print("Enter number of children: ");
        int children = sc.nextInt();

        int chocolatesPerChild = chocolates / children;
        int remainingChocolates = chocolates % children;

        System.out.println("The number of chocolates each child gets is " +
                chocolatesPerChild +
                " and the number of remaining chocolates are " +
                remainingChocolates);
    }
}

