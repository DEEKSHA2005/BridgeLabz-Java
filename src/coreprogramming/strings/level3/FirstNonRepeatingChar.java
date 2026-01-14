package coreprogramming.strings.level3;

import java.util.Scanner;

public class FirstNonRepeatingChar {

    public static char findFirstNonRepeatingCharacter(String text) {

        int[] frequency = new int[256];

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (frequency[ch] == 1) {
                return ch;
            }
        }

        return '\0';
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        char result = findFirstNonRepeatingCharacter(text);

        if (result != '\0') {
            System.out.println("\nFirst non-repeating character: " + result);
        } else {
            System.out.println("\nNo non-repeating character found");
        }
    }
}

