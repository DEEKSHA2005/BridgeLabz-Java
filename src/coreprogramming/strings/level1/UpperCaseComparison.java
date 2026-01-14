package coreprogramming.strings.level1;

import java.util.Scanner;

public class UpperCaseComparison {

    public static String convertToUpperCaseUsingASCII(String text) {

        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                result += (char) (ch - 32);
            } else {
                result += ch;
            }
        }
        return result;
    }

    public static boolean compareStringsUsingCharAt(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String customUpper = convertToUpperCaseUsingASCII(text);

        String builtInUpper = text.toUpperCase();

        boolean result = compareStringsUsingCharAt(customUpper, builtInUpper);

        System.out.println("\nUppercase using user-defined method: " + customUpper);
        System.out.println("Uppercase using toUpperCase(): " + builtInUpper);
        System.out.println("Both strings are equal: " + result);
    }
}
