package coreprogramming.methods.level2;

import java.util.Scanner;

public class BMICalculator {

    public static void calculateBMI(double[][] data) {

        for (int i = 0; i < data.length; i++) {

            double weight = data[i][0];
            double heightCm = data[i][1];
            double heightMeter = heightCm / 100;

            double bmi = weight / (heightMeter * heightMeter);
            data[i][2] = bmi;
        }
    }

    public static String[] determineBMIStatus(double[][] data) {

        String[] status = new String[data.length];

        for (int i = 0; i < data.length; i++) {

            double bmi = data[i][2];

            if (bmi < 18.5) {
                status[i] = "Underweight";
            } else if (bmi < 25) {
                status[i] = "Normal";
            } else if (bmi < 30) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
        return status;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[][] persons = new double[10][3];

        for (int i = 0; i < persons.length; i++) {

            System.out.print("Enter weight (kg) of person " + (i + 1) + ": ");
            persons[i][0] = sc.nextDouble();

            System.out.print("Enter height (cm) of person " + (i + 1) + ": ");
            persons[i][1] = sc.nextDouble();
        }

        calculateBMI(persons);

        String[] bmiStatus = determineBMIStatus(persons);

        for (int i = 0; i < persons.length; i++) {

            System.out.printf(
                    "Person %d: Weight = %.2f kg, Height = %.2f cm, BMI = %.2f, Status = %s%n",
                    (i + 1),
                    persons[i][0],
                    persons[i][1],
                    persons[i][2],
                    bmiStatus[i]
            );
        }
    }
}

