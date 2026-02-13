package ioprogramming.csvhandling;

import java.io.*;
import java.util.*;

public class DetectDuplicates {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
        Set<String> set = new HashSet<>();

        br.readLine();
        String line;

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            if (!set.add(data[0])) {
                System.out.println("Duplicate Found: " + line);
            }
        }

        br.close();
    }
}
