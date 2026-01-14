package coreprogramming.programmingelements.level2;

import java.util.Scanner;

public class TotalIncome {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();

        System.out.print("Enter bonus: ");
        double bonus = sc.nextDouble();

        double totalIncome = salary + bonus;

        System.out.println("The salary is INR " + salary +
                " and bonus is INR " + bonus +
                ". Hence Total Income is INR " + totalIncome);
    }
}
