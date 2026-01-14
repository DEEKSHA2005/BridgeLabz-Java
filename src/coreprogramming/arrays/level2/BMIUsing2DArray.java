package coreprogramming.arrays.level2;

import java.util.Scanner;

public class BMIUsing2DArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[][] data = new double[5][2]; // [][0]=weight, [][1]=height

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter weight of person " + (i + 1) + " (kg): ");
            data[i][0] = sc.nextDouble();

            System.out.print("Enter height of person " + (i + 1) + " (cm): ");
            data[i][1] = sc.nextDouble();
        }

        for (int i = 0; i < 5; i++) {
            double heightMeter = data[i][1] / 100;
            double bmi = data[i][0] / (heightMeter * heightMeter);
            System.out.println("BMI of person " + (i + 1) + " = " + bmi);
        }
    }
}
