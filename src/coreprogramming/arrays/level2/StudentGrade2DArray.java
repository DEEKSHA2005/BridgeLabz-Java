package coreprogramming.arrays.level2;

import java.util.Scanner;

public class StudentGrade2DArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int students = sc.nextInt();

        int[][] marks = new int[students][3]; // 3 subjects: Physics, Chemistry, Maths

        // Input marks
        for (int i = 0; i < students; i++) {
            System.out.println("Enter marks for Student " + (i + 1));

            System.out.print("Physics: ");
            marks[i][0] = sc.nextInt();

            System.out.print("Chemistry: ");
            marks[i][1] = sc.nextInt();

            System.out.print("Maths: ");
            marks[i][2] = sc.nextInt();
        }

        // Calculate percentage and grade
        for (int i = 0; i < students; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double percentage = total / 3.0;

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
