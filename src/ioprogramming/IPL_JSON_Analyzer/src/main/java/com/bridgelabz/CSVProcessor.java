package com.bridgelabz;

import java.io.*;

/*
 * CSVProcessor class reads IPL match data from a CSV file,
 * applies censorship rules, and writes the processed data
 * into a new CSV output file.
 */
public class CSVProcessor {

    public static void processCSV() {

        try {

            // Load CSV file from resources folder
            InputStream input = CSVProcessor.class
                    .getClassLoader()
                    .getResourceAsStream("ipl.csv");

            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            // Output file to store censored CSV data
            BufferedWriter writer = new BufferedWriter(new FileWriter("censored_ipl.csv"));

            String line;
            boolean header = true;

            // Read CSV file line by line
            while ((line = reader.readLine()) != null) {

                // Write header without modification
                if (header) {
                    writer.write(line);
                    writer.newLine();
                    header = false;
                    continue;
                }

                // Split CSV values
                String[] data = line.split(",");

                // Mask team names
                data[1] = maskTeam(data[1]);
                data[2] = maskTeam(data[2]);
                data[5] = maskTeam(data[5]);

                // Redact player of the match
                data[6] = "REDACTED";

                // Write modified data to new CSV file
                writer.write(String.join(",", data));
                writer.newLine();
            }

            reader.close();
            writer.close();

            System.out.println("CSV file processed.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Method to mask part of the team name.
     * Example: "Chennai Super Kings" → "Chennai ***"
     */
    private static String maskTeam(String team) {

        if (team.contains(" ")) {
            return team.split(" ")[0] + " ***";
        }

        return "***";
    }
}