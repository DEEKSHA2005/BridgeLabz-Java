package javacollectionsstream.java8features.day7FunctionalInterface;

interface SquareCalculator {

    // Single abstract method
    int calculateSquare(int number);

    // Default method
    default void printResult(int number) {
        int result = calculateSquare(number);
        System.out.println("Square of " + number + " is: " + result);
    }
}

public class CustomFunctionalInterfaceExample {

    public static void main(String[] args) {

        // Lambda expression implementation
        SquareCalculator squareCalculator =
                n -> n * n;

        squareCalculator.printResult(6);
    }
}
