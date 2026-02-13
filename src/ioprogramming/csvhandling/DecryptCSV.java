package ioprogramming.csvhandling;

import java.io.*;

public class DecryptCSV {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("secure.csv"))) {

            br.readLine();
            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                String decryptedEmail = AESUtil.decrypt(data[2]);
                String decryptedSalary = AESUtil.decrypt(data[3]);

                System.out.println("ID: " + data[0]);
                System.out.println("Name: " + data[1]);
                System.out.println("Email: " + decryptedEmail);
                System.out.println("Salary: " + decryptedSalary);
                System.out.println("-----------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

