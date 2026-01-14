package coreprogramming.strings.level3;

import java.util.Scanner;

public class DeckOfCards {

    static String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    static String[] ranks = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King", "Ace"
    };

    public static String[] initializeDeck() {
        String[] deck = new String[suits.length * ranks.length];
        int index = 0;

        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    public static void shuffleDeck(String[] deck) {
        int n = deck.length;

        for (int i = 0; i < n; i++) {
            int random = i + (int)(Math.random() * (n - i));
            String temp = deck[i];
            deck[i] = deck[random];
            deck[random] = temp;
        }
    }

    public static String[][] distributeCards(String[] deck, int players, int cards) {

        if (players * cards > deck.length) {
            return null;
        }

        String[][] playerCards = new String[players][cards];
        int index = 0;

        for (int i = 0; i < players; i++) {
            for (int j = 0; j < cards; j++) {
                playerCards[i][j] = deck[index++];
            }
        }
        return playerCards;
    }

    public static void printPlayers(String[][] players) {

        for (int i = 0; i < players.length; i++) {
            System.out.println("\nPlayer " + (i + 1) + ":");
            for (String card : players[i]) {
                System.out.println(card);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int players = sc.nextInt();

        System.out.print("Enter number of cards per player: ");
        int cards = sc.nextInt();

        String[] deck = initializeDeck();
        shuffleDeck(deck);

        String[][] distributed = distributeCards(deck, players, cards);

        if (distributed == null) {
            System.out.println("Cannot distribute cards.");
        } else {
            printPlayers(distributed);
        }
    }
}
