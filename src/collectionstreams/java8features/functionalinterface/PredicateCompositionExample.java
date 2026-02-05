package javacollectionsstream.java8features.day7FunctionalInterface;

import java.util.*;
import java.util.function.Predicate;

public class PredicateCompositionExample {

    public static void main(String[] args) {

        List<String> words = List.of(
                "banana", "apple", "cat", "application",
                "dog", "avocado", "grape"
        );

        String substring = "app";

        // Predicate 1: length > 5
        Predicate<String> lengthGreaterThanFive =
                s -> s.length() > 5;

        // Predicate 2: contains specific substring
        Predicate<String> containsSubstring =
                s -> s.contains(substring);

        // Predicate composition (AND)
        Predicate<String> combinedPredicate =
                lengthGreaterThanFive.and(containsSubstring);

        // Apply filter
        words.stream()
                .filter(combinedPredicate)
                .forEach(System.out::println);
    }
}
