package coreprogramming.arrays.level2;

import java.util.Scanner;

public class BMIUsingArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] weight = new double[5];
        double[] height = new double[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter weight of person " + (i + 1) + " (kg): ");
            weight[i] = sc.nextDouble();

            System.out.print("Enter height of person " + (i + 1) + " (cm): ");
            height[i] = sc.nextDouble();
        }

        for (int i = 0; i < 5; i++) {
            double heightMeter = height[i] / 100;
            double bmi = weight[i] / (heightMeter * heightMeter);
            System.out.println("BMI of person " + (i + 1) + " = " + bmi);
        }
    }
}

