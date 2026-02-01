package collectionstreams.iostreams;

import java.io.*;
import java.util.*;

public class WordCountTop5 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("text.txt"));
        Map<String,Integer> map = new HashMap<>();
        String line;

        while ((line = br.readLine()) != null) {
            for (String word : line.toLowerCase().split("\\W+")) {
                map.put(word, map.getOrDefault(word,0)+1);
            }
        }

        map.entrySet().stream()
                .sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
                .limit(5)
                .forEach(e -> System.out.println(e.getKey()+" : "+e.getValue()));
    }
}

