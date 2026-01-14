package coreprogramming.methods.level3;

import java.util.Scanner;

public class ZaraBonusCalculator {

    public static double[][] readEmployeeData(int employees) {

        Scanner sc = new Scanner(System.in);
        double[][] data = new double[employees][2];

        for (int i = 0; i < employees; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1));

            System.out.print("Enter Old Salary: ");
            data[i][0] = sc.nextDouble();

            System.out.print("Enter Years of Service: ");
            data[i][1] = sc.nextDouble();
        }
        return data;
    }

    public static double[][] calculateNewSalaryAndBonus(double[][] employeeData) {

        int n = employeeData.length;
        double[][] result = new double[n][2];

        for (int i = 0; i < n; i++) {

            double oldSalary = employeeData[i][0];
            double years = employeeData[i][1];
            double bonusRate;

            if (years > 5) {
                bonusRate = 0.05;
            } else {
                bonusRate = 0.02;
            }

            double bonus = oldSalary * bonusRate;
            double newSalary = oldSalary + bonus;

            result[i][0] = newSalary;
            result[i][1] = bonus;
        }
        return result;
    }

    public static void displaySalaryReport(
            double[][] employeeData,
            double[][] newSalaryData) {

        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        System.out.println("\nEmployee  OldSalary  Years  Bonus    NewSalary");
        System.out.println("------------------------------------------------");

        for (int i = 0; i < employeeData.length; i++) {

            double oldSalary = employeeData[i][0];
            double years = employeeData[i][1];
            double bonus = newSalaryData[i][1];
            double newSalary = newSalaryData[i][0];

            totalOldSalary += oldSalary;
            totalNewSalary += newSalary;
            totalBonus += bonus;

            System.out.printf("%-9d %-10.2f %-6.0f %-8.2f %-10.2f%n",
                    (i + 1), oldSalary, years, bonus, newSalary);
        }

        System.out.println("------------------------------------------------");
        System.out.printf("TOTAL      %-10.2f        %-8.2f %-10.2f%n",
                totalOldSalary, totalBonus, totalNewSalary);
    }

    public static void main(String[] args) {

        int employees = 10;

        double[][] employeeData = readEmployeeData(employees);

        double[][] newSalaryData = calculateNewSalaryAndBonus(employeeData);

        displaySalaryReport(employeeData, newSalaryData);
    }
}

