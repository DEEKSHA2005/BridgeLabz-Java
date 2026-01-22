package dsa.linearbinary;

import java.io.*;
import java.util.Scanner;

public class ChallengeComparison {

    public static void main(String[] args) {

        int n = 1_000_000;


        long start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append("hello");
        long end = System.nanoTime();
        System.out.println("StringBuilder time: " + (end - start));


        start = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < n; i++) sbf.append("hello");
        end = System.nanoTime();
        System.out.println("StringBuffer time: " + (end - start));


        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String path = sc.nextLine();


        try {
            start = System.nanoTime();
            BufferedReader br1 = new BufferedReader(new FileReader(path));
            int words1 = 0;
            String line;
            while ((line = br1.readLine()) != null) {
                words1 += line.split("\\s+").length;
            }
            br1.close();
            end = System.nanoTime();
            System.out.println("FileReader words: " + words1 +
                    ", time: " + (end - start));


            start = System.nanoTime();
            BufferedReader br2 = new BufferedReader(
                    new InputStreamReader(new FileInputStream(path)));
            int words2 = 0;
            while ((line = br2.readLine()) != null) {
                words2 += line.split("\\s+").length;
            }
            br2.close();
            end = System.nanoTime();
            System.out.println("InputStreamReader words: " + words2 +
                    ", time: " + (end - start));

        } catch (IOException e) {
            System.out.println("File not found. Please check the file path.");
        }

        sc.close();
    }
}
