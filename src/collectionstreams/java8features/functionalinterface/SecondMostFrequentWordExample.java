package javacollectionsstream.java8features.day7FunctionalInterface;

import java.util.*;
import java.util.stream.Collectors;

public class SecondMostFrequentWordExample {

    public static void main(String[] args) {

        // 1️⃣ Input sequence
        String text = "java streams make java code simple and java streams powerful";

        // 2️⃣ Tokenize + count frequency
        Map<String, Long> wordFrequency =
                Arrays.stream(
                                text.toLowerCase()
                                        .replaceAll("[^a-z ]", "")
                                        .split("\\s+")
                        )
                        .collect(Collectors.groupingBy(
                                word -> word,
                                Collectors.counting()
                        ));

        // 3️⃣ Find second most repeated word
        wordFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .skip(1)   // skip the most frequent
                .findFirst()
                .ifPresent(entry ->
                        System.out.println(
                                "Second most frequent word: "
                                        + entry.getKey() + " = " + entry.getValue()
                        ));
    }
}
