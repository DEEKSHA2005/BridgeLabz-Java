package ioprogramming.csvhandling;

import java.io.*;

public class UpdateCSV {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("updated.csv"));

        String line = br.readLine();
        bw.write(line + "\n");

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            if (data[2].equalsIgnoreCase("IT")) {
                double salary = Double.parseDouble(data[3]);
                salary = salary * 1.10;
                data[3] = String.valueOf(salary);
            }

            bw.write(String.join(",", data) + "\n");
        }

        br.close();
        bw.close();

        System.out.println("Updated file created");
    }
}

