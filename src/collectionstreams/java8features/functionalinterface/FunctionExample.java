package collectionstreams.java8features.functionalinterface;

import java.util.function.Function;

public class FunctionExample {

    public static void main(String[] args) {

        // Function to calculate area of a circle
        Function<Double, Double> calculateArea =
                radius -> Math.PI * radius * radius;

        double radius = 5.0;

        double area = calculateArea.apply(radius);

        System.out.println("Radius: " + radius);
        System.out.println("Area of Circle: " + area);
    }
}
