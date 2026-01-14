package coreprogramming.strings.level2;

import java.util.Scanner;

public class RockPaperScissorsGame {

    public static String getComputerChoice() {

        int choice = (int)(Math.random() * 3);

        if (choice == 0) return "rock";
        else if (choice == 1) return "paper";
        else return "scissors";
    }

    public static String findWinner(String user, String computer) {

        if (user.equals(computer)) {
            return "Draw";
        }

        if ((user.equals("rock") && computer.equals("scissors")) ||
                (user.equals("paper") && computer.equals("rock")) ||
                (user.equals("scissors") && computer.equals("paper"))) {
            return "User";
        }

        return "Computer";
    }

    public static String[][] calculateStats(String[][] results) {

        int userWins = 0, computerWins = 0, draws = 0;
        int totalGames = results.length;

        for (int i = 0; i < results.length; i++) {
            if (results[i][3].equals("User")) userWins++;
            else if (results[i][3].equals("Computer")) computerWins++;
            else draws++;
        }

        double userPercent = (userWins * 100.0) / totalGames;
        double computerPercent = (computerWins * 100.0) / totalGames;

        String[][] stats = new String[2][2];
        stats[0][0] = "User";
        stats[0][1] = String.valueOf(userPercent);
        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(computerPercent);

        return stats;
    }

    public static void displayResults(String[][] results, String[][] stats) {

        System.out.println("\nGame\tUser Choice\tComputer Choice\tWinner");
        System.out.println("------------------------------------------------");

        for (int i = 0; i < results.length; i++) {
            System.out.println(
                    results[i][0] + "\t" +
                            results[i][1] + "\t\t" +
                            results[i][2] + "\t\t" +
                            results[i][3]
            );
        }

        System.out.println("\nWinning Percentage:");
        for (int i = 0; i < stats.length; i++) {
            System.out.println(stats[i][0] + ": " + stats[i][1] + "%");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of games: ");
        int games = sc.nextInt();

        String[][] results = new String[games][4];

        for (int i = 0; i < games; i++) {

            System.out.print("Enter your choice for game " + (i + 1) +
                    " (rock/paper/scissors): ");
            String userChoice = sc.next();

            String computerChoice = getComputerChoice();
            String winner = findWinner(userChoice, computerChoice);

            results[i][0] = String.valueOf(i + 1);
            results[i][1] = userChoice;
            results[i][2] = computerChoice;
            results[i][3] = winner;
        }

        String[][] stats = calculateStats(results);
        displayResults(results, stats);
    }
}
