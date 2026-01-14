package coreprogramming.arrays.level2;

import java.util.Scanner;

public class StudentGradeArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] marks = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter marks of student " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }

        for (int i = 0; i < 5; i++) {
            int percentage = marks[i];
            char grade;

            if (percentage >= 90) {
                grade = 'A';
            } else if (percentage >= 75) {
                grade = 'B';
            } else if (percentage >= 60) {
                grade = 'C';
            } else if (percentage >= 40) {
                grade = 'D';
            } else {
                grade = 'F';
            }

            System.out.println("Student " + (i + 1) +
                    " Percentage = " + percentage +
                    " Grade = " + grade);
        }
    }
}

