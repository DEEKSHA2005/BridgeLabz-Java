package coreprogramming.strings.extras2;

import java.util.Scanner;

public class NumberGuessingGame {

    public static int generateGuess(int low, int high) {
        return (low + high) / 2;
    }

    public static String getFeedback(Scanner sc) {
        System.out.print("Enter feedback (high / low / correct): ");
        return sc.next().toLowerCase();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int low = 1;
        int high = 100;
        int attempts = 0;
        boolean guessed = false;

        System.out.println("Think of a number between 1 and 100.");

        while (!guessed) {

            int guess = generateGuess(low, high);
            attempts++;

            System.out.println("\nComputer guesses: " + guess);
            String feedback = getFeedback(sc);

            if (feedback.equals("correct")) {
                guessed = true;
                System.out.println("\nComputer guessed your number correctly!");
                System.out.println("Total attempts: " + attempts);
            }
            else if (feedback.equals("high")) {
                high = guess - 1;
            }
            else if (feedback.equals("low")) {
                low = guess + 1;
            }
            else {
                System.out.println("Invalid input! Please enter high, low, or correct.");
            }
        }
    }
}

