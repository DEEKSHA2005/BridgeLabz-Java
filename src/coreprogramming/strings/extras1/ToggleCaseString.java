package coreprogramming.strings.extras1;

import java.util.Scanner;

public class ToggleCaseString {

    public static String toggleCase(String text) {

        String result = "";

        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                result += (char)(ch + 32);
            }

            else if (ch >= 'a' && ch <= 'z') {
                result += (char)(ch - 32);
            }

            else {
                result += ch;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String toggled = toggleCase(input);

        System.out.println("Toggled String: " + toggled);
    }
}

