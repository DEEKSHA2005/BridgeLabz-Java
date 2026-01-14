package coreprogramming.strings.level2;

import java.util.Scanner;

public class SplitTextWithoutSplit {

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
        int index = 0;

        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[index++] = i;
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

    public static boolean compareStringArrays(String[] arr1, String[] arr2) {

        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[] customWords = splitTextWithoutSplit(text);

        String[] builtInWords = text.split(" ");

        System.out.println("\nWords using user-defined method:");
        for (String word : customWords) {
            System.out.println(word);
        }

        System.out.println("\nWords using split() method:");
        for (String word : builtInWords) {
            System.out.println(word);
        }

        boolean result = compareStringArrays(customWords, builtInWords);
        System.out.println("\nBoth results are equal: " + result);
    }
}

