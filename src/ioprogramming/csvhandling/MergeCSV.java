package ioprogramming.csvhandling;

import java.io.*;
import java.util.*;

public class MergeCSV {

    public static void main(String[] args) {

        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String outputFile = "merged.csv";

        Map<String, String[]> studentMap = new HashMap<>();

        try (
                BufferedReader br1 = new BufferedReader(new FileReader(file1));
                BufferedReader br2 = new BufferedReader(new FileReader(file2));
                BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))
        ) {


            br1.readLine();
            String line;

            while ((line = br1.readLine()) != null) {
                String[] data = line.split(",");
                studentMap.put(data[0], data);
            }


            bw.write("ID,Name,Age,Marks,Grade\n");

            br2.readLine();

            while ((line = br2.readLine()) != null) {

                String[] data2 = line.split(",");
                String id = data2[0];

                if (studentMap.containsKey(id)) {
                    String[] data1 = studentMap.get(id);

                    bw.write(id + "," +
                            data1[1] + "," +
                            data1[2] + "," +
                            data2[1] + "," +
                            data2[2] + "\n");
                }
            }

            System.out.println("✅ Files merged successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

