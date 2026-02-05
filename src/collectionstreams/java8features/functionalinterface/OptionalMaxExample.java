package javacollectionsstream.java8features.day7FunctionalInterface;

import java.util.*;

public class OptionalMaxExample {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(10, 45, 23, 67, 5);

        Optional<Integer> maxValue =
                numbers.stream().max(Integer::compareTo);

        maxValue.ifPresentOrElse(
                value -> System.out.println("Maximum value: " + value),
                () -> System.out.println("List is empty")
        );

        List<Integer> emptyList = List.of();

        Optional<Integer> emptyResult =
                emptyList.stream().max(Integer::compareTo);

        emptyResult.ifPresentOrElse(
                value -> System.out.println("Maximum value: " + value),
                () -> System.out.println("No maximum value found")
        );
    }
}
