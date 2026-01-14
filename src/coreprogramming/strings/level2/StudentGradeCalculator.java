package coreprogramming.strings.level2;

import java.util.Scanner;

public class StudentGradeCalculator {

    public static int[][] generatePCMScores(int students) {

        int[][] pcm = new int[students][3];

        for (int i = 0; i < students; i++) {
            pcm[i][0] = (int)(Math.random() * 90) + 10; // Physics
            pcm[i][1] = (int)(Math.random() * 90) + 10; // Chemistry
            pcm[i][2] = (int)(Math.random() * 90) + 10; // Maths
        }
        return pcm;
    }

    public static double[][] calculateScores(int[][] pcm) {

        double[][] scores = new double[pcm.length][3];

        for (int i = 0; i < pcm.length; i++) {

            int total = pcm[i][0] + pcm[i][1] + pcm[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            scores[i][0] = total;
            scores[i][1] = Math.round(average * 100.0) / 100.0;
            scores[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return scores;
    }

    public static String[] calculateGrades(double[][] scores) {

        String[] grades = new String[scores.length];

        for (int i = 0; i < scores.length; i++) {

            double percent = scores[i][2];

            if (percent >= 80) grades[i] = "A";
            else if (percent >= 70) grades[i] = "B";
            else if (percent >= 60) grades[i] = "C";
            else if (percent >= 50) grades[i] = "D";
            else if (percent >= 40) grades[i] = "E";
            else grades[i] = "R";
        }
        return grades;
    }

    public static void displayScoreCard(int[][] pcm, double[][] scores, String[] grades) {

        System.out.println("\nStu\tP\tC\tM\tTotal\tAverage\tPercentage\tGrade");
        System.out.println("-------------------------------------------------------");

        for (int i = 0; i < pcm.length; i++) {
            System.out.println(
                    (i + 1) + "\t" +
                            pcm[i][0] + "\t" +
                            pcm[i][1] + "\t" +
                            pcm[i][2] + "\t" +
                            (int)scores[i][0] + "\t" +
                            scores[i][1] + "\t" +
                            scores[i][2] + "\t\t" +
                            grades[i]
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int students = sc.nextInt();

        int[][] pcm = generatePCMScores(students);
        double[][] scores = calculateScores(pcm);
        String[] grades = calculateGrades(scores);

        displayScoreCard(pcm, scores, grades);
    }
}

