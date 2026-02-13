package ioprogramming.csvhandling;

import java.io.*;

public class LargeCSVReader {

    public static void main(String[] args) {

        String fileName = "largefile.csv";
        int batchSize = 100;
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            br.readLine();
            String line;

            while ((line = br.readLine()) != null) {


                count++;

                if (count % batchSize == 0) {
                    System.out.println("Processed " + count + " records...");
                }
            }

            System.out.println("✅ Total Records Processed: " + count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

