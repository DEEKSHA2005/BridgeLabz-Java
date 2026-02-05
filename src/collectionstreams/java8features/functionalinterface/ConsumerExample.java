package javacollectionsstream.java8features.day7FunctionalInterface;
import java.util.*;
import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[] args) {

        List<String> names = List.of(
                "java", "stream", "lambda", "consumer"
        );

        // Consumer to print string in uppercase
        Consumer<String> printUpperCase =
                s -> System.out.println(s.toUpperCase());

        // Using Consumer with forEach
        names.forEach(printUpperCase);
    }
}
