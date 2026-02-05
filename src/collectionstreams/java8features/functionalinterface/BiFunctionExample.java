package javacollectionsstream.java8features.day7FunctionalInterface;

import java.util.function.BiFunction;

public class BiFunctionExample {

    public static void main(String[] args) {

        // BiFunction to concatenate two strings with space
        BiFunction<String, String, String> concatenate =
                (s1, s2) -> s1 + " " + s2;

        String firstName = "Java";
        String secondName = "Streams";

        String result = concatenate.apply(firstName, secondName);

        System.out.println(result);
    }
}
