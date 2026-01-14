package coreprogramming.strings.extras1;

import java.util.Scanner;

public class LongestWord {

    public static String findLongestWord(String sentence) {

        String[] words = sentence.split(" ");
        String longestWord = words[0];

        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > longestWord.length()) {
                longestWord = words[i];
            }
        }
        return longestWord;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        String longest = findLongestWord(sentence);

        System.out.println("Longest word: " + longest);
        System.out.println("Length: " + longest.length());
    }
}

