package javacollectionsstream.java8features.day7FunctionalInterface;

import java.util.*;
import java.util.stream.Collectors;

public class MostFrequentWordsExample {

    public static void main(String[] args) {

        // 1️⃣ Read the text corpus
        String text = "Java streams make Java code simple and Java streams make code powerful";

        int topN = 3;

        // 2️⃣ Tokenize text (remove punctuation, lowercase, split)
        Map<String, Long> wordFrequency =
                Arrays.stream(
                                text.toLowerCase()
                                        .replaceAll("[^a-z ]", "")
                                        .split("\\s+")
                        )

                        // 3️⃣ Count frequency of each word
                        .collect(Collectors.groupingBy(
                                word -> word,
                                Collectors.counting()
                        ));

        // 4️⃣ Find top N most frequent words
        wordFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topN)

                // 5️⃣ Display result
                .forEach(entry ->
                        System.out.println(
                                entry.getKey() + " = " + entry.getValue()
                        ));
    }
}
