package com.bridgelabz;

/*
 * Main class of the application.
 * This class starts the program and calls methods to process
 * JSON and CSV IPL match data.
 */
public class Main {

    public static void main(String[] args) {

        // Process IPL data from JSON file
        JSONProcessor.processJSON();

        // Process IPL data from CSV file
        CSVProcessor.processCSV();

        // Print completion message
        System.out.println("Processing completed successfully.");
    }
}