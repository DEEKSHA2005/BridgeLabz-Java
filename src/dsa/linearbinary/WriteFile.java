package dsa.linearbinary;

import java.io.*;

public class WriteFile {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileWriter fw = new FileWriter("output.txt", true);

        String input;
        System.out.println("Enter text (type 'exit' to stop):");

        while (true) {
            input = br.readLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            fw.write(input + "\n");
        }

        fw.close();
        br.close();
        System.out.println("Input saved to file.");
    }
}
