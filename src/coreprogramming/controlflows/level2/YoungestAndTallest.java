package coreprogramming.controlflows.level2;

import java.util.Scanner;

public class YoungestAndTallest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Amar's age: ");
        int amarAge = sc.nextInt();
        System.out.print("Enter Amar's height: ");
        double amarHeight = sc.nextDouble();

        System.out.print("Enter Akbar's age: ");
        int akbarAge = sc.nextInt();
        System.out.print("Enter Akbar's height: ");
        double akbarHeight = sc.nextDouble();

        System.out.print("Enter Anthony's age: ");
        int anthonyAge = sc.nextInt();
        System.out.print("Enter Anthony's height: ");
        double anthonyHeight = sc.nextDouble();

        String youngest = "Amar";
        if (akbarAge < amarAge && akbarAge < anthonyAge) {
            youngest = "Akbar";
        } else if (anthonyAge < amarAge && anthonyAge < akbarAge) {
            youngest = "Anthony";
        }

        String tallest = "Amar";
        if (akbarHeight > amarHeight && akbarHeight > anthonyHeight) {
            tallest = "Akbar";
        } else if (anthonyHeight > amarHeight && anthonyHeight > akbarHeight) {
            tallest = "Anthony";
        }

        System.out.println("The youngest friend is " + youngest);
        System.out.println("The tallest friend is " + tallest);
    }
}

