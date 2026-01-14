package coreprogramming.strings.level3;

import java.util.Scanner;

public class CharFrequencyCounter {

    public static String[][] findCharacterFrequencies(String text) {

        int[] frequency = new int[256];

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }

        int distinctCount = 0;
        for (int i = 0; i < 256; i++) {
            if (frequency[i] > 0) {
                distinctCount++;
            }
        }

        String[][] result = new String[distinctCount][2];
        int index = 0;

        boolean[] added = new boolean[256];

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            int ascii = ch;

            if (!added[ascii]) {
                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(frequency[ascii]);
                added[ascii] = true;
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[][] result = findCharacterFrequencies(text);

        System.out.println("\nCharacter\tFrequency");
        System.out.println("-------------------------");

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + "\t\t" + result[i][1]);
        }
    }
}

