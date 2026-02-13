package ioprogramming.csvhandling;

import java.io.*;
import java.util.regex.*;

public class ValidateCSV {

    public static void main(String[] args) {

        String fileName = "students.csv";

        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern emailPattern = Pattern.compile(emailRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line = br.readLine();
            int rowNumber = 1;

            while ((line = br.readLine()) != null) {
                rowNumber++;

                String[] data = line.split(",");

                if (data.length < 4) {
                    System.out.println("Invalid format at row " + rowNumber);
                    continue;
                }

                String email = data[2];
                String phone = data[3];

                boolean isValid = true;

                if (!emailPattern.matcher(email).matches()) {
                    System.out.println("❌ Invalid Email at row " + rowNumber + ": " + line);
                    isValid = false;
                }

                if (!phone.matches("\\d{10}")) {
                    System.out.println("❌ Invalid Phone at row " + rowNumber + ": " + line);
                    isValid = false;
                }

                if (!isValid) {
                    System.out.println("-----------------------------------");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

