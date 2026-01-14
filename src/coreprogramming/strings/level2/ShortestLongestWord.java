package coreprogramming.strings.level2;

import java.util.Scanner;

public class ShortestLongestWord {

    public static int findLengthWithoutLength(String text) {

        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
        }
        return count;
    }

    public static String[] splitTextWithoutSplit(String text) {

        int length = findLengthWithoutLength(text);
        int spaceCount = 0;

        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        int[] spaceIndexes = new int[spaceCount];
        int idx = 0;

        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[idx++] = i;
            }
        }

        String[] words = new String[spaceCount + 1];
        int start = 0;

        for (int i = 0; i < spaceCount; i++) {
            words[i] = "";
            for (int j = start; j < spaceIndexes[i]; j++) {
                words[i] += text.charAt(j);
            }
            start = spaceIndexes[i] + 1;
        }

        words[spaceCount] = "";
        for (int i = start; i < length; i++) {
            words[spaceCount] += text.charAt(i);
        }

        return words;
    }

    public static String[][] createWordLengthTable(String[] words) {

        String[][] table = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            int length = findLengthWithoutLength(words[i]);
            table[i][0] = words[i];
            table[i][1] = String.valueOf(length);
        }
        return table;
    }

    public static int[] findShortestAndLongest(String[][] table) {

        int shortest = Integer.parseInt(table[0][1]);
        int longest = Integer.parseInt(table[0][1]);

        for (int i = 1; i < table.length; i++) {
            int length = Integer.parseInt(table[i][1]);

            if (length < shortest) {
                shortest = length;
            }
            if (length > longest) {
                longest = length;
            }
        }

        return new int[]{shortest, longest};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[] words = splitTextWithoutSplit(text);

        String[][] table = createWordLengthTable(words);

        System.out.println("\nWord\t\tLength");
        System.out.println("-------------------");

        for (int i = 0; i < table.length; i++) {
            int length = Integer.parseInt(table[i][1]);
            System.out.println(table[i][0] + "\t\t" + length);
        }

        int[] result = findShortestAndLongest(table);

        System.out.println("\nShortest word length: " + result[0]);
        System.out.println("Longest word length: " + result[1]);
    }
}
