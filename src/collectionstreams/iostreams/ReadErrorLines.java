package collectionstreams.iostreams;

import java.io.*;

public class ReadErrorLines {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("log.txt"));
        String line;

        while ((line = br.readLine()) != null) {
            if (line.toLowerCase().contains("error")) {
                System.out.println(line);
            }
        }
        br.close();
    }
}

