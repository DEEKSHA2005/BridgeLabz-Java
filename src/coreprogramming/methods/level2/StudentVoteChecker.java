package coreprogramming.methods.level2;

import java.util.Scanner;

public class StudentVoteChecker {

    public static boolean canStudentVote(int age) {

        if (age < 0) {
            return false;
        }

        if (age >= 18) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] ages = new int[10];

        for (int i = 0; i < ages.length; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            ages[i] = sc.nextInt();
        }

        System.out.println("\n--- Voting Eligibility Result ---");

        for (int i = 0; i < ages.length; i++) {

            if (ages[i] < 0) {
                System.out.println("Student " + (i + 1) + ": Invalid age");
            } else if (canStudentVote(ages[i])) {
                System.out.println("Student " + (i + 1) + " can vote");
            } else {
                System.out.println("Student " + (i + 1) + " cannot vote");
            }
        }
    }
}

