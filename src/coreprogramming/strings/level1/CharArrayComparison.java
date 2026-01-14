package coreprogramming.strings.level1;

import java.util.Scanner;

public class CharArrayComparison {

    public static char[] getCharactersUsingCharAt(String text) {

        char[] chars = new char[text.length()];

        for (int i = 0; i < text.length(); i++) {
            chars[i] = text.charAt(i);
        }
        return chars;
    }

    public static boolean compareCharArrays(char[] arr1, char[] arr2) {

        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        char[] userArray = getCharactersUsingCharAt(text);

        char[] builtInArray = text.toCharArray();

        boolean result = compareCharArrays(userArray, builtInArray);

        System.out.println("\nCharacters using user-defined method:");
        for (char c : userArray) {
            System.out.print(c + " ");
        }

        System.out.println("\n\nCharacters using toCharArray():");
        for (char c : builtInArray) {
            System.out.print(c + " ");
        }

        System.out.println("\n\nBoth character arrays are equal: " + result);
    }
}

