package coreprogramming.strings.extras1;

import java.util.Scanner;

public class MostFrequentChar {

    public static char findMostFrequentCharacter(String text) {

        int[] frequency = new int[256];

        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }

        int maxFreq = 0;
        char mostFrequent = ' ';

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (frequency[ch] > maxFreq) {
                maxFreq = frequency[ch];
                mostFrequent = ch;
            }
        }

        return mostFrequent;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        char result = findMostFrequentCharacter(text);

        System.out.println("Most Frequent Character: '" + result + "'");
    }
}
