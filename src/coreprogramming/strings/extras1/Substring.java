package coreprogramming.strings.extras1;

import java.util.Scanner;

public class Substring {

    public static int countSubstringOccurrences(String text, String sub) {

        int count = 0;
        int textLength = text.length();
        int subLength = sub.length();

        for (int i = 0; i <= textLength - subLength; i++) {

            boolean match = true;

            for (int j = 0; j < subLength; j++) {
                if (text.charAt(i + j) != sub.charAt(j)) {
                    match = false;
                    break;
                }
            }

            if (match) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter main string: ");
        String text = sc.nextLine();

        System.out.print("Enter substring: ");
        String sub = sc.nextLine();

        int result = countSubstringOccurrences(text, sub);

        System.out.println("Substring occurs " + result + " times");
    }
}

