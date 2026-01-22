package dsa.linearbinary;

import java.io.*;
import java.util.Scanner;

public class ReadFile {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file path: ");
        String path = sc.nextLine();

        try (
                FileInputStream fis = new FileInputStream(path);
                InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
                BufferedReader br = new BufferedReader(isr)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("File not found. Please check the file path.");
        }

        sc.close();
    }
}
