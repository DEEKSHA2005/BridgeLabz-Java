package collectionstreams.java8features.functionalinterface;

import java.util.*;

public class FilterStringExample {

    public static void main(String[] args) {

        List<String> names = List.of("Apple", "Banana", "Avocado", "Mango", "Apricot");

        names.stream()
                .filter(s -> s.startsWith("A"))
                .forEach(System.out::println);
    }
}
