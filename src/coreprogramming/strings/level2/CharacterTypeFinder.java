package coreprogramming.strings.level2;

import java.util.Scanner;

public class CharacterTypeFinder {

    public static String checkCharacterType(char ch) {

        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        if (ch >= 'a' && ch <= 'z') {

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }

        return "Not a Letter";
    }

    public static String[][] findCharacterTypes(String text) {

        String[][] table = new String[text.length()][2];

        for (int i = 0; i < text.length(); i++) {
            table[i][0] = String.valueOf(text.charAt(i));
            table[i][1] = checkCharacterType(text.charAt(i));
        }

        return table;
    }

    public static void displayTable(String[][] table) {

        System.out.println("\nCharacter\tType");
        System.out.println("--------------------");

        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + "\t\t" + table[i][1]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        // Find character types
        String[][] result = findCharacterTypes(text);

        // Display result
        displayTable(result);
    }
}

