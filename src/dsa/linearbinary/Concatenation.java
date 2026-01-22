package dsa.linearbinary;

import java.util.Scanner;

public class Concatenation {

    public static String concatenate(String[] arr) {
        StringBuffer sb = new StringBuffer();

        for (String s : arr) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] arr = new String[n];
        System.out.println("Enter strings:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }

        System.out.println("Concatenated string: " + concatenate(arr));
        sc.close();
    }
}

