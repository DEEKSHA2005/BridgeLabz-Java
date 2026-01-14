package coreprogramming.strings.level3;

import java.util.Scanner;

public class BMICalculator {

    public static String[] calculateBMI(double weight, double heightCm) {

        double heightM = heightCm / 100;
        double bmi = weight / (heightM * heightM);
        bmi = Math.round(bmi * 100.0) / 100.0;

        String status;
        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi < 25) {
            status = "Normal";
        } else if (bmi < 30) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        return new String[]{
                String.valueOf(heightCm),
                String.valueOf(weight),
                String.valueOf(bmi),
                status
        };
    }

    public static String[][] buildBMITable(double[][] data) {

        String[][] table = new String[data.length][4];

        for (int i = 0; i < data.length; i++) {
            table[i] = calculateBMI(data[i][0], data[i][1]);
        }
        return table;
    }

    public static void displayTable(String[][] table) {

        System.out.println("\nHeight(cm)\tWeight(kg)\tBMI\t\tStatus");
        System.out.println("------------------------------------------------");

        for (int i = 0; i < table.length; i++) {
            System.out.println(
                    table[i][0] + "\t\t" +
                            table[i][1] + "\t\t" +
                            table[i][2] + "\t\t" +
                            table[i][3]
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][2];

        for (int i = 0; i < 10; i++) {
            System.out.print("Person " + (i + 1) + " weight (kg): ");
            data[i][0] = sc.nextDouble();

            System.out.print("Person " + (i + 1) + " height (cm): ");
            data[i][1] = sc.nextDouble();
        }

        String[][] result = buildBMITable(data);
        displayTable(result);
    }
}

