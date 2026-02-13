package ioprogramming.csvhandling;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class CSVToJSON {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("students.csv"));
        br.readLine(); // skip header

        String line;
        StringBuilder json = new StringBuilder();
        json.append("[\n");

        while ((line = br.readLine()) != null) {

            String[] data = line.split(",");

            json.append("  {")
                    .append("\"id\":").append(data[0]).append(",")
                    .append("\"name\":\"").append(data[1]).append("\",")
                    .append("\"age\":").append(data[2]).append(",")
                    .append("\"marks\":").append(data[3])
                    .append("},\n");
        }

        json.deleteCharAt(json.length() - 2); // remove last comma
        json.append("]");

        Files.write(Paths.get("output.json"), json.toString().getBytes());

        br.close();

        System.out.println("✅ CSV Converted to JSON");
    }
}

