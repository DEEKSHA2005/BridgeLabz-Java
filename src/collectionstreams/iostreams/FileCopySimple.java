package collectionstreams.iostreams;

import java.io.*;

public class FileCopySimple {
    public static void main(String[] args) {

        File source = new File("source.txt");
        File dest = new File("destination.txt");

        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            System.out.println("File copied successfully");

        } catch (IOException e) {
            System.out.println("Source file not found or error occurred");
        }
    }
}

