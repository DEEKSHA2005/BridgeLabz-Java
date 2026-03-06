package com.bridgelabz;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.InputStream;
import java.util.List;

/*
 * JSONProcessor class reads IPL match data from a JSON file,
 * applies censorship rules, and writes the processed data
 * into a new JSON output file.
 */
public class JSONProcessor {

    public static void processJSON() {

        try {

            // ObjectMapper is used to read and write JSON data
            ObjectMapper mapper = new ObjectMapper();

            // Load JSON file from resources folder using ClassLoader
            InputStream input = JSONProcessor.class
                    .getClassLoader()
                    .getResourceAsStream("ipl.json");

            // Convert JSON data into a list of IPLMatch objects
            List<IPLMatch> matches =
                    mapper.readValue(input, new TypeReference<List<IPLMatch>>() {});

            // Apply censorship rules to each match
            for (IPLMatch match : matches) {

                // Mask team names
                match.team1 = maskTeam(match.team1);
                match.team2 = maskTeam(match.team2);
                match.winner = maskTeam(match.winner);

                // Redact player of the match
                match.player_of_match = "REDACTED";
            }

            // Write censored data to new JSON file
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File("censored_ipl.json"), matches);

            System.out.println("JSON file processed.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Method to mask part of the team name.
     * Example: "Mumbai Indians" → "Mumbai ***"
     */
    private static String maskTeam(String team) {

        if (team.contains(" ")) {
            return team.split(" ")[0] + " ***";
        }

        return "***";
    }
}