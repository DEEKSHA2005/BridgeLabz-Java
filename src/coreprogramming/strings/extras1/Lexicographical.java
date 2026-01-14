package coreprogramming.strings.extras1;

import java.util.Scanner;

public class Lexicographical {

    public static int compareStrings(String s1, String s2) {

        int minLength = Math.min(s1.length(), s2.length());

        for (int i = 0; i < minLength; i++) {

            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (c1 < c2) {
                return -1;
            } else if (c1 > c2) {
                return 1;
            }
        }

        if (s1.length() < s2.length()) {
            return -1;
        } else if (s1.length() > s2.length()) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();

        int result = compareStrings(str1, str2);

        if (result == -1) {
            System.out.println("\"" + str1 + "\" comes before \"" + str2 + "\" in lexicographical order");
        } else if (result == 1) {
            System.out.println("\"" + str1 + "\" comes after \"" + str2 + "\" in lexicographical order");
        } else {
            System.out.println("Both strings are equal");
        }
    }
}

