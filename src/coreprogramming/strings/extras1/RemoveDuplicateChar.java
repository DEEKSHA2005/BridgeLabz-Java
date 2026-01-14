package coreprogramming.strings.extras1;

import java.util.Scanner;

public class RemoveDuplicateChar {

    public static String removeDuplicates(String text) {

        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            boolean isDuplicate = false;
            for (int j = 0; j < result.length(); j++) {
                if (currentChar == result.charAt(j)) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                result = result + currentChar;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String output = removeDuplicates(input);

        System.out.println("String after removing duplicates: " + output);
    }
}

