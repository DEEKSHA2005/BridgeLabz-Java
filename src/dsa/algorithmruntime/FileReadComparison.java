package dsa.algorithmruntime;

import java.io.*;
import java.util.Scanner;

public class FileReadComparison {

    static int countWords(BufferedReader br) throws IOException {
        int cnt = 0; String line;
        while ((line = br.readLine()) != null)
            cnt += line.trim().isEmpty() ? 0 : line.split("\\s+").length;
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String path = sc.nextLine();

        long s = System.nanoTime();
        int w1 = countWords(new BufferedReader(new FileReader(path)));
        System.out.println("FileReader words: " + w1 + ", time: " + (System.nanoTime() - s));

        s = System.nanoTime();
        int w2 = countWords(new BufferedReader(
                new InputStreamReader(new FileInputStream(path), "UTF-8")));
        System.out.println("InputStreamReader words: " + w2 + ", time: " + (System.nanoTime() - s));

        sc.close();
    }
}
