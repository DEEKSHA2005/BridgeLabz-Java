package dsa.linearbinary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class WordCount {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file path: ");
        String filePath = sc.nextLine();

        System.out.print("Enter word to count: ");
        String target = sc.nextLine();

        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String w : words) {
                    if (w.equalsIgnoreCase(target)) {
                        count++;
                    }
                }
            }

            System.out.println("Word '" + target + "' occurs " + count + " times.");

        } catch (IOException e) {
            System.out.println("File not found. Please check the file path.");
        }

        sc.close();
    }
}
