package ioprogramming.csvhandling;

import java.io.*;

public class EncryptCSV {

    public static void main(String[] args) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("secure.csv"))) {

            bw.write("ID,Name,Email,Salary\n");

            String encryptedEmail = AESUtil.encrypt("ravi@gmail.com");
            String encryptedSalary = AESUtil.encrypt("75000");

            bw.write("1,Ravi," + encryptedEmail + "," + encryptedSalary + "\n");

            System.out.println("✅ Encrypted CSV Created");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

