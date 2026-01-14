package oops.fundamental.level2;

import java.util.Scanner;

public class Palindrome {

    String text;

    boolean isPalindrome() {
        String reversed = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            reversed += text.charAt(i);
        }
        return text.equals(reversed);
    }

    void displayResult() {
        if (isPalindrome())
            System.out.println("Palindrome String");
        else
            System.out.println("Not a Palindrome String");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Palindrome p = new Palindrome();

        System.out.print("Enter a string: ");
        p.text = sc.nextLine();

        p.displayResult();
    }
}

