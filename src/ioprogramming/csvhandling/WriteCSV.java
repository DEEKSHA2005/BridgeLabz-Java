package ioprogramming.csvhandling;

import java.io.*;

public class WriteCSV {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter("employees.csv"));

        bw.write("ID,Name,Department,Salary\n");
        bw.write("1,Ravi,IT,70000\n");
        bw.write("2,Anjali,HR,50000\n");
        bw.write("3,Kiran,IT,80000\n");
        bw.write("4,Meena,Finance,60000\n");
        bw.write("5,Rahul,IT,75000\n");

        bw.close();
        System.out.println("File written successfully");
    }
}
