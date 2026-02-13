package ioprogramming.csvhandling;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class JSONToCSV {

    public static void main(String[] args) throws Exception {

        String json = new String(Files.readAllBytes(Paths.get("students.json")));

        json = json.replace("[", "")
                .replace("]", "")
                .replace("{", "")
                .replace("}", "")
                .replace("\"", "");

        String[] records = json.split("},");

        BufferedWriter bw = new BufferedWriter(new FileWriter("students.csv"));
        bw.write("ID,Name,Age,Marks\n");

        for (String record : records) {

            String[] fields = record.split(",");

            String id = fields[0].split(":")[1];
            String name = fields[1].split(":")[1];
            String age = fields[2].split(":")[1];
            String marks = fields[3].split(":")[1];

            bw.write(id + "," + name + "," + age + "," + marks + "\n");
        }

        bw.close();
        System.out.println("✅ JSON Converted to CSV");
    }
}

