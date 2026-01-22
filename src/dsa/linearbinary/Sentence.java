package dsa.linearbinary;

import java.util.Scanner;

public class Sentence {

    static int findSentence(String[] sentences, String word) {
        for (int i = 0; i < sentences.length; i++)
            if (sentences[i].contains(word))
                return i;
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of sentences: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] sentences = new String[n];
        System.out.println("Enter sentences:");
        for (int i = 0; i < n; i++)
            sentences[i] = sc.nextLine();

        System.out.print("Enter word to search: ");
        String word = sc.nextLine();

        int index = findSentence(sentences, word);

        if (index == -1)
            System.out.println("Word not found in any sentence");
        else
            System.out.println("Word found in sentence index " + index +
                    ": " + sentences[index]);

        sc.close();
    }
}
