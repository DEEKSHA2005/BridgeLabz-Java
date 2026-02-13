package ioprogramming.csvhandling;

import java.io.*;

public class SearchCSV {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("employees.csv"));

        br.readLine();
        String line;
        String searchName = "Ravi";

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            if (data[1].equalsIgnoreCase(searchName)) {
                System.out.println("Department: " + data[2]);
                System.out.println("Salary: " + data[3]);
            }
        }

        br.close();
    }
}

